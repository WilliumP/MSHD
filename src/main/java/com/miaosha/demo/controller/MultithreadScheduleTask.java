package com.miaosha.demo.controller;

import com.miaosha.demo.domain.*;
import com.miaosha.demo.json.OperateJsonFile;
import com.miaosha.demo.service.*;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@EnableScheduling   // 1.开启定时任务
@EnableAsync        // 2.开启多线程
public class MultithreadScheduleTask {

    OperateJsonFile op = new OperateJsonFile();

    String[] prefix = new String[]{"101","102","103",
                                    "104","105","201",
                                    "202","203","204",
                                    "301","302","303",
                                    "304","401"};
    @Async
    @Scheduled(fixedDelay = 1200000)  //间隔1分钟
    public void first() {
        try {
            //死亡
            for(String tmp : prefix){
                List<DeathStatistics> deathStatisticsList = op.read_deathStatisticsList(tmp + "/death_statistics.json");
                if(deathStatisticsList != null) {
                	DeathStatisticsService.beifen();
                    for (DeathStatistics deathStatistics : deathStatisticsList) {
                        String a = deathStatistics.getReporting_unit();
                        deathStatistics.setReporting_unit(tmp + "_" + a);
                    }
                    DeathStatisticsService.insertByJson(deathStatisticsList);
                    System.out.println("上传数据已更新，数据如下：");
                    for (DeathStatistics c : deathStatisticsList) {
                        System.out.println(c.toString());
                    }
                }
            }
            //受伤
            for(String tmp : prefix){
                List<Shoushang> shoushangList = op.read_ShoushangList(tmp + "/Shoushang.json");
                if(shoushangList != null) {
                	ShoushangService.beifen();
                    for (Shoushang shoushang : shoushangList) {
                        String a = shoushang.getReporting_unit();
                        shoushang.setReporting_unit(tmp + "_" + a);
                    }
                    ShoushangService.insertByJson(shoushangList);
                    System.out.println("上传数据已更新，数据如下：");
                    for (Shoushang c : shoushangList) {
                        System.out.println(c.toString());
                    }
                }
            }

            //失踪
            for(String tmp : prefix){
                List<Shizong> ShizongList = op.read_ShizongList(tmp + "/Shizong.json");
                if(ShizongList != null) {
                	ShizongService.beifen();
                    for (Shizong shizong : ShizongList) {
                        String a = shizong.getReporting_unit();
                        shizong.setReporting_unit(tmp + "_" + a);
                    }
                    ShizongService.insertByJson(ShizongList);
                    System.out.println("上传数据已更新，数据如下：");
                    for (Shizong c : ShizongList) {
                        System.out.println(c.toString());
                    }
                }
            }

            //土木
            for(String tmp : prefix){
                List<CivilStructure> civilStructureList = op.read_civilStructureList(tmp + "/civil_structure.json");
                if (civilStructureList != null) {
                	CivilStructureService.beifen();
                    for (CivilStructure civilStructure : civilStructureList) {
                        String a = civilStructure.getReporting_unit();
                        civilStructure.setReporting_unit(tmp + "_" + a);
                    }
                    CivilStructureService.insertByJson(civilStructureList);
                    System.out.println("上传数据已更新，数据如下：");
                    for (CivilStructure c : civilStructureList) {
                        System.out.println(c.toString());
                    }
                }
            }

            //砖木
            for(String tmp : prefix){
                List<Zhuanmu> ZhuanmuList = op.read_ZhuanmuList(tmp + "/Zhuanmu.json");
                if (ZhuanmuList != null) {
                	ZhuanmuService.beifen();
                    for (Zhuanmu zhuanmu : ZhuanmuList) {
                        String a = zhuanmu.getReporting_unit();
                        zhuanmu.setReporting_unit(tmp + "_" + a);
                    }
                    ZhuanmuService.insertByJson(ZhuanmuList);
                    System.out.println("上传数据已更新，数据如下：");
                    for (Zhuanmu c : ZhuanmuList) {
                        System.out.println(c.toString());
                    }
                }
            }

            //砖混
            for(String tmp : prefix){
                List<Zhuanhun> ZhuanhunList = op.read_ZhuanhunList(tmp + "/Zhuanhun.json");
                if (ZhuanhunList != null) {
                	ZhuanhunService.beifen();
                    for (Zhuanhun zhuanhun : ZhuanhunList) {
                        String a = zhuanhun.getReporting_unit();
                        zhuanhun.setReporting_unit(tmp + "_" + a);
                    }
                    ZhuanhunService.insertByJson(ZhuanhunList);
                    System.out.println("上传数据已更新，数据如下：");
                    for (Zhuanhun c : ZhuanhunList) {
                        System.out.println(c.toString());
                    }
                }
            }

            //框架
            for(String tmp : prefix){
                List<Kuangjia> KuangjiaList = op.read_KuangjiaList(tmp + "/Kuangjia.json");
                if (KuangjiaList != null) {
                	KuangjiaService.beifen();
                    for (Kuangjia kuangjia : KuangjiaList) {
                        String a = kuangjia.getReporting_unit();
                        kuangjia.setReporting_unit(tmp + "_" + a);
                    }
                    KuangjiaService.insertByJson(KuangjiaList);
                    System.out.println("上传数据已更新，数据如下：");
                    for (Kuangjia c : KuangjiaList) {
                        System.out.println(c.toString());
                    }
                }
            }

            //其他
            for(String tmp : prefix){
                List<FangwuQita> FangwuQitaList = op.read_FangwuQitaList(tmp + "/FangwuQita.json");
                if (FangwuQitaList != null) {
                	FangwuQitaService.beifen();
                    for (FangwuQita fangwuQita : FangwuQitaList) {
                        String a = fangwuQita.getReporting_unit();
                        fangwuQita.setReporting_unit(tmp + "_" + a);
                    }
                    FangwuQitaService.insertByJson(FangwuQitaList);
                    System.out.println("上传数据已更新，数据如下：");
                    for (FangwuQita c : FangwuQitaList) {
                        System.out.println(c.toString());
                    }
                }
            }

            //交通
            for(String tmp : prefix){
                List<Jiaotong> JiaotongList = op.read_JiaotongList(tmp + "/Jiaotong.json");
                if (JiaotongList != null) {
                	JiaotongService.beifen();
                    for (Jiaotong jiaotong : JiaotongList) {
                        String a = jiaotong.getReporting_unit();
                        jiaotong.setReporting_unit(tmp + "_" + a);
                    }
                    JiaotongService.insertByJson(JiaotongList);
                    System.out.println("上传数据已更新，数据如下：");
                    for (Jiaotong c : JiaotongList) {
                        System.out.println(c.toString());
                    }
                }
            }

            //供水
            for(String tmp : prefix){
                List<Gongshui> GongshuiList = op.read_GongshuiList(tmp + "/Gongshui.json");
                if (GongshuiList != null) {
                	GongshuiService.beifen();
                    for (Gongshui gongshui : GongshuiList) {
                        String a = gongshui.getReporting_unit();
                        gongshui.setReporting_unit(tmp + "_" + a);
                    }
                    GongshuiService.insertByJson(GongshuiList);
                    System.out.println("上传数据已更新，数据如下：");
                    for (Gongshui c : GongshuiList) {
                        System.out.println(c.toString());
                    }
                }
            }

            //输油
            for(String tmp : prefix){
                List<Shuyou> ShuyouList = op.read_ShuyouList(tmp + "/Shuyou.json");
                if (ShuyouList != null) {
                	ShuyouService.beifen();
                    for (Shuyou shuyou : ShuyouList) {
                        String a = shuyou.getReporting_unit();
                        shuyou.setReporting_unit(tmp + "_" + a);
                    }
                    ShuyouService.insertByJson(ShuyouList);
                    System.out.println("上传数据已更新，数据如下：");
                    for (Shuyou c : ShuyouList) {
                        System.out.println(c.toString());
                    }
                }
            }

            //燃气
            for(String tmp : prefix){
                List<Ranqi> RanqiList = op.read_RanqiList(tmp + "/Ranqi.json");
                if (RanqiList != null) {
                	RanqiService.beifen();
                    for (Ranqi ranqi : RanqiList) {
                        String a = ranqi.getReporting_unit();
                        ranqi.setReporting_unit(tmp + "_" + a);
                    }
                    RanqiService.insertByJson(RanqiList);
                    System.out.println("上传数据已更新，数据如下：");
                    for (Ranqi c : RanqiList) {
                        System.out.println(c.toString());
                    }
                }
            }

            //电力
            for(String tmp : prefix){
                List<Dianli> DianliList = op.read_DianliList(tmp + "/Dianli.json");
                if (DianliList != null) {
                	DianliService.beifen();
                    for (Dianli dianli : DianliList) {
                        String a = dianli.getReporting_unit();
                        dianli.setReporting_unit(tmp + "_" + a);
                    }
                    DianliService.insertByJson(DianliList);
                    System.out.println("上传数据已更新，数据如下：");
                    for (Dianli c : DianliList) {
                        System.out.println(c.toString());
                    }
                }
            }

            //通信
            for(String tmp : prefix){
                List<Disaster> disasterList = op.read_disasterList(tmp + "/comm_disaster.json");
                if(disasterList != null){
                	DisasterService.beifen();
                    for (Disaster disaster : disasterList) {
                        String a = disaster.getReporting_unit();
                        disaster.setReporting_unit(tmp + "_" + a);
                    }
                    DisasterService.insertByJson(disasterList);
                    System.out.println("上传数据已更新，数据如下：");
                    for(Disaster c: disasterList){
                        System.out.println(c.toString());
                    }
                }
            }

            //水利
            for(String tmp : prefix){
                List<Shuili> ShuiliList = op.read_ShuiliList(tmp + "/Shuili.json");
                if(ShuiliList != null){
                	ShuiliService.beifen();
                    for (Shuili shuili : ShuiliList) {
                        String a = shuili.getReporting_unit();
                        shuili.setReporting_unit(tmp + "_" + a);
                    }
                    ShuiliService.insertByJson(ShuiliList);
                    System.out.println("上传数据已更新，数据如下：");
                    for(Shuili c: ShuiliList){
                        System.out.println(c.toString());
                    }
                }
            }

            //崩塌
            for(String tmp : prefix){
                List<CollapseRecord> collapseRecordList = op.read_collapseRecordList(tmp + "/collapse_record.json");
                if (collapseRecordList != null) {
                	CollapseRecordService.beifen();
                    for (CollapseRecord collapseRecord : collapseRecordList) {
                        String a = collapseRecord.getReporting_unit();
                        collapseRecord.setReporting_unit(tmp + "_" + a);
                    }
                    CollapseRecordService.insertByJson(collapseRecordList);
                    System.out.println("上传数据已更新，数据如下：");
                    for (CollapseRecord c : collapseRecordList) {
                        System.out.println(c.toString());
                    }
                }
            }

            //滑坡
            for(String tmp : prefix){
                List<Huapo> HuapoList = op.read_HuapoList(tmp + "/Huapo.json");
                if(HuapoList != null){
                	HuapoService.beifen();
                    for (Huapo huapo : HuapoList) {
                        String a = huapo.getReporting_unit();
                        huapo.setReporting_unit(tmp + "_" + a);
                    }
                    HuapoService.insertByJson(HuapoList);
                    System.out.println("上传数据已更新，数据如下：");
                    for(Huapo c: HuapoList){
                        System.out.println(c.toString());
                    }
                }
            }

            //泥石流
            for(String tmp : prefix){
                List<Nishiliu> NishiliuList = op.read_NishiliuList(tmp + "/Nishiliu.json");
                if(NishiliuList != null){
                	NishiliuService.beifen();
                    for (Nishiliu nishiliu : NishiliuList) {
                        String a = nishiliu.getReporting_unit();
                        nishiliu.setReporting_unit(tmp + "_" + a);
                    }
                    NishiliuService.insertByJson(NishiliuList);
                    System.out.println("上传数据已更新，数据如下：");
                    for(Nishiliu c: NishiliuList){
                        System.out.println(c.toString());
                    }
                }
            }

            //岩溶塌陷
            for(String tmp : prefix){
                List<Yanrongtanta> YanrongtantaList = op.read_YanrongtantaList(tmp + "/Yanrongtanta.json");
                if(YanrongtantaList != null){
                	YanrongtantaService.beifen();
                    for (Yanrongtanta yanrongtanta : YanrongtantaList) {
                        String a = yanrongtanta.getReporting_unit();
                        yanrongtanta.setReporting_unit(tmp + "_" + a);
                    }
                    YanrongtantaService.insertByJson(YanrongtantaList);
                    System.out.println("上传数据已更新，数据如下：");
                    for(Yanrongtanta c: YanrongtantaList){
                        System.out.println(c.toString());
                    }
                }
            }

            //地裂缝
            for(String tmp : prefix){
                List<Diliefeng> DiliefengList = op.read_DiliefengList(tmp + "/Diliefeng.json");
                if(DiliefengList != null){
                	DiliefengService.beifen();
                    for (Diliefeng diliefeng : DiliefengList) {
                        String a = diliefeng.getReporting_unit();
                        diliefeng.setReporting_unit(tmp + "_" + a);
                    }
                    DiliefengService.insertByJson(DiliefengList);
                    System.out.println("上传数据已更新，数据如下：");
                    for(Diliefeng c: DiliefengList){
                        System.out.println(c.toString());
                    }
                }
            }

            //地面沉降
            for(String tmp : prefix){
                List<Dimianchenjiang> DimianchenjiangList = op.read_DimianchenjiangList(tmp + "/Dimianchenjiang.json");
                if(DimianchenjiangList != null){
                	DimianchenjiangService.beifen();
                    for (Dimianchenjiang dimianchenjiang : DimianchenjiangList) {
                        String a = dimianchenjiang.getReporting_unit();
                        dimianchenjiang.setReporting_unit(tmp + "_" + a);
                    }
                    DimianchenjiangService.insertByJson(DimianchenjiangList);
                    System.out.println("上传数据已更新，数据如下：");
                    for(Dimianchenjiang c: DimianchenjiangList){
                        System.out.println(c.toString());
                    }
                }
            }

            //次生灾害其他
            for(String tmp : prefix){
                List<CishengzaihaiQita> CishengzaihaiQitaList = op.read_CishengzaihaiQitaList(tmp + "/CishengzaihaiQita.json");
                if(CishengzaihaiQitaList != null){
                	CishengzaihaiQitaService.beifen();
                    for (CishengzaihaiQita cishengzaihaiQita : CishengzaihaiQitaList) {
                        String a = cishengzaihaiQita.getReporting_unit();
                        cishengzaihaiQita.setReporting_unit(tmp + "_" + a);
                    }
                    CishengzaihaiQitaService.insertByJson(CishengzaihaiQitaList);
                    System.out.println("上传数据已更新，数据如下：");
                    for(CishengzaihaiQita c: CishengzaihaiQitaList){
                        System.out.println(c.toString());
                    }
                }
            }

            //基本震情
            for(String tmp : prefix){
                List<ZhenqingJiben> ZhenqingJibenList = op.read_ZhenqingJibenList(tmp + "/ZhenqingJiben.json");
                if(ZhenqingJibenList != null){
                	ZhenqingJibenService.beifen();
                    for (ZhenqingJiben zhenqingJiben : ZhenqingJibenList) {
                        String a = zhenqingJiben.getReporting_unit();
                        zhenqingJiben.setReporting_unit(tmp + "_" + a);
                    }
                    ZhenqingJibenService.insertByJson(ZhenqingJibenList);
                    System.out.println("上传数据已更新，数据如下：");
                    for(ZhenqingJiben c: ZhenqingJibenList){
                        System.out.println(c.toString());
                    }
                }
            }

            //灾情预测
            for(String tmp : prefix) {
                List<DisasterPrediction> disasterPredictionList = op.read_disasterPredictionList(tmp + "/disaster_prediction.json");
                if (disasterPredictionList != null) {
                	DisasterPredictionService.beifen();
                    for (DisasterPrediction disasterPrediction : disasterPredictionList) {
                        String a = disasterPrediction.getReporting_unit();
                        disasterPrediction.setReporting_unit(tmp + "_" + a);
                    }
                    DisasterPredictionService.insertByJson(disasterPredictionList);
                    System.out.println("上传数据已更新，数据如下：");
                    for (DisasterPrediction c : disasterPredictionList) {
                        System.out.println(c.toString());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
