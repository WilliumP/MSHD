package com.miaosha.demo.controller;

import com.miaosha.demo.domain.*;
import com.miaosha.demo.service.DisasterRequestService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class ClientController {

	//导出数据
	@RequestMapping("/dataexport")
	public String exportData() {
		return "Client_Export";
	}

	@RequestMapping(value = "/download", method = RequestMethod.POST)
	public String someoneWantDownload(@RequestParam("disasterOptions") String disasterOptions, @RequestParam("url") String url,
									  @RequestParam("request_unit") String re, @RequestParam("code") String code) {
		DisasterRequest dr = new DisasterRequest();
		Date date = new Date();
		dr.setDisaster_type(disasterOptions);
		dr.setO_url(url);
		dr.setStatus("0");
		dr.setRequest_unit(re);
		dr.setId("1111111111111111111");

		String strDateFormat = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
		dr.setDate(sdf.format(date));
		System.out.println(dr.toString());
		DisasterRequestService.insertOne(dr);
		return "Client_Export";
	}
}
    /*
    //下载文件
    @RequestMapping("/download")
    @ResponseBody
    //ResponseEntity<byte[]>
    public  void testResponseEntity(@RequestParam("disasterOptions") String disasterOptions,
                                                     @RequestParam("url") String url,
                                                     HttpSession session) throws IOException {
        OperateJsonFile op = new OperateJsonFile();
        byte [] body = null;
        String str = "";
        switch (disasterOptions){
            case ("1"):
            case ("11"):
            case ("12"):
            case ("13"):
                List<DeathStatistics> deathStatistics = null;
                str= JSON.toJSONString(deathStatistics);
                break;
            case ("2"):
            case ("21"):
            case ("22"):
            case ("23"):
            case ("24"):
            case ("25"):
                List<CivilStructure> civilStructures = null;
                str= JSON.toJSONString(civilStructures);
                break;
            case ("3"):
            case ("31"):
            case ("32"):
            case ("33"):
            case ("34"):
            case ("35"):
            case ("36"):
            case ("37"):
                List<Disaster> disasters  = disasterService.selectAll();
                try {
                    op.write_disaster(disasters, url + "/comm_disaster.json");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                str= JSON.toJSONString(disasters);
                break;
            case ("4"):
            case ("41"):
            case ("42"):
            case ("43"):
            case ("44"):
            case ("45"):
            case ("46"):
            case ("47"):
                List<CollapseRecord> collapseRecords = null;
                str= JSON.toJSONString(collapseRecords);
                break;
            case ("5"):
            case ("51"):
            case ("52"):
                List<DisasterPrediction> disasterPredictions = null;
                str= JSON.toJSONString(disasterPredictions);
                break;
            default:
                break;
        }
//        InputStream in = new ByteArrayInputStream(str.getBytes());
//        body = new byte[in.available()];
//        in.read(body);
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("Content-Disposition", "attachment;filename=data.txt");
//
//        HttpStatus statusCode = HttpStatus.OK;
//
//        ResponseEntity<byte[]> response = new ResponseEntity<byte[]>(body, headers, statusCode);

        //导出的后置处理，将记录写入
        //return response;
    }
*/

