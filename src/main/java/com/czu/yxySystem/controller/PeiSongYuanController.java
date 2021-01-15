package com.czu.yxySystem.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.czu.yxySystem.entity.DO.PeiSongYuanDO;
import com.czu.yxySystem.entity.DO.QuanXianDO;
import com.czu.yxySystem.service.PeiSongYuanService;
import com.czu.yxySystem.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description 配送员信息页面的控制器
 * @Author Yxy
 * @Date 2021/1/15 15:27
 **/
@RestController
@RequestMapping("/peiSongYuan")
public class PeiSongYuanController {

    @Autowired
    private PeiSongYuanService peiSongYuanService;

    @RequestMapping("/getList")
    public R getList(Integer page, Integer limit,
            @RequestParam(value = "xingMing", required = false, defaultValue = "") String xingMing,
            @RequestParam(value = "chengHao", required = false, defaultValue = "") String chengHao,
            @RequestParam(value = "fuZeQuYu", required = false, defaultValue = "") String fuZeQuYu
    ) {
        List<PeiSongYuanDO> list = peiSongYuanService.getList(page, limit, xingMing, chengHao, fuZeQuYu);
        int count = peiSongYuanService.getCount(page, limit, xingMing, chengHao, fuZeQuYu);
        return R.ok().put("list", list).put("count", count);
    }

}
