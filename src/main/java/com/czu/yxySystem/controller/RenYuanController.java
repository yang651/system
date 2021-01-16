package com.czu.yxySystem.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.czu.yxySystem.entity.DO.ChengHaoDO;
import com.czu.yxySystem.entity.DO.RenYuanDO;
import com.czu.yxySystem.entity.DTO.RenYuanGuanLiDTO;
import com.czu.yxySystem.service.ChengHaoService;
import com.czu.yxySystem.service.RenYuanService;
import com.czu.yxySystem.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.SimpleFormatter;

/**
 * @Description 配送员信息页面的控制器
 * @Author Yxy
 * @Date 2021/1/15 15:27
 **/
@RestController
@RequestMapping("/renYuan")
public class RenYuanController {

    @Autowired
    private RenYuanService renYuanService;

    @Autowired
    private ChengHaoService chengHaoService;

    /**
     * @Description: 获取人员List
     * @Param: [page, limit, xingMing, chengHao, fuZeQuYu]
     * @return: com.czu.yxySystem.util.R
     * @Author: Yxy
     * @Date: 2021/1/16 9:02
     **/
    @RequestMapping("/getList")
    public R getList(Integer page, Integer limit,
            @RequestParam(value = "xingMing", required = false, defaultValue = "") String xingMing,
            @RequestParam(value = "chengHao", required = false, defaultValue = "") String chengHao,
            @RequestParam(value = "fuZeQuYu", required = false, defaultValue = "") String fuZeQuYu
    ) {
        List<RenYuanDO> list = renYuanService.getList(page, limit, xingMing, chengHao, fuZeQuYu);
        int count = renYuanService.getCount(page, limit, xingMing, chengHao, fuZeQuYu);
        return R.ok().put("list", list).put("count", count);
    }

    /**
     * @Description:获取称号list
     * @Param: []
     * @return: com.czu.yxySystem.util.R
     * @Author: Yxy
     * @Date: 2021/1/16 13:58
     **/
    @RequestMapping("/getChengHaoList.do")
    public R getChengHaoList(){
        List<ChengHaoDO> list = chengHaoService.list(new QueryWrapper<ChengHaoDO>().orderByDesc("jiBie"));
        return R.ok().put("list",list);
    }


    /**
     * @Description: 人员add（入职）
     * @Param: [renYuanDO]
     * @return: com.czu.yxySystem.util.R
     * @Author: Yxy
     * @Date: 2021/1/16 14:42
     **/
    @RequestMapping("/add.do")
    public R add(@RequestBody RenYuanGuanLiDTO renYuanGuanLiDTO){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        RenYuanDO renYuanDO = new RenYuanDO();
        renYuanDO.setXingMing(renYuanGuanLiDTO.getXingMing());
        renYuanDO.setNianLing(renYuanGuanLiDTO.getNianLing());
        try {
            renYuanDO.setRuZhiRiQi(sdf.parse(renYuanGuanLiDTO.getRuZhiRiQi()));
        } catch (ParseException e) {
            return R.error("时间格式错误!");
        }
        renYuanDO.setChengHao(renYuanGuanLiDTO.getChengHao());
        renYuanDO.setLianXiDianHua(renYuanGuanLiDTO.getLianXiDianHua());
        renYuanDO.setJiLuRiQi(new Date());
        renYuanDO.setXingBie(renYuanGuanLiDTO.getXingBie());
        renYuanDO.setShiFouLiZhi(false);
        renYuanDO.setZhuangTai(1);
        boolean save = renYuanService.save(renYuanDO);
        if(!save){
            return R.error("系统繁忙，请联系管理员!");
        }
        return R.ok("保存成功！");
    }

}