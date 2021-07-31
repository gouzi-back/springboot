package com.bootjdbc.demo.controller;/**
 * @Auther:haha
 * @Date:2021/4/25 - 04 - 25 22:53
 * @Description:com.hyy.controller
 * @Version: 1.0
 */


import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSONObject;
import com.bootjdbc.demo.pojo.Department;
import com.bootjdbc.demo.pojo.EmpExcel;
import com.bootjdbc.demo.pojo.Employee;
import com.bootjdbc.demo.pojo.PatientInfo;
import com.bootjdbc.demo.service.impl.DepartmentServiceImpl;
import com.bootjdbc.demo.service.impl.EmployeeServiceImpl;
import com.bootjdbc.demo.util.HeSuanSoapUtil;
import com.bootjdbc.demo.util.JsonXmlUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * EmpController
 * <功能详细描述>
 *
 * @author 员工管理
 * @version [版本号, 2021/4/25 22:53]
 * @see  [相关类/方法]
 * @since [产品/模块版本]
 */
@Controller
public class EmpController {

    @Autowired
    EmployeeServiceImpl employeeService;
    @Autowired
    DepartmentServiceImpl departmentService;

    @RequestMapping("/emps")
    public String list(Model model){
        List<Employee> employees= employeeService.listAll();
        model.addAttribute("employees",employees);
        return "emp/list";
    }

    @RequestMapping("/emp")
    public String toAdd(Model model){

        //查出所有部门的信息
       List<Department> department= departmentService.listAll();
       model.addAttribute("department",department);
        return "emp/add";
    }

    @RequestMapping("/add")
    public String Add(Employee employee){
        //进行添加的操作
        employeeService.add(employee);
        return "redirect:/emps";
    }

    @RequestMapping("/toUpdate/{id}")
    public String toUpdate(@PathVariable("id") Integer id, Model model){

        Employee employeeById =employeeService.listAllById(id);
        model.addAttribute("employeeById",employeeById);

        //查出所有部门的信息
        List<Department> department= departmentService.listAll();
        model.addAttribute("department",department);

        return "emp/update";
    }
    @RequestMapping("/update")
    public String update(Employee employee){
        employeeService.update(employee);
        return "redirect:/emps";
    }

    @RequestMapping("/del/{id}")
    public String Del(@PathVariable("id") Integer id){
        employeeService.delete(id);
        return "redirect:/emps";
    }

    @RequestMapping("/excel")
    public void excelExport(HttpServletResponse response) throws IOException {
        StringBuilder title =new StringBuilder();
        title.append("员工信息");
        response.setHeader("Content-Disposition","attachment;filename="+new String((title.toString()+".xls").getBytes(),"iso-8859-1"));
        List<Employee> results = employeeService.listAll();
        Workbook workbook= ExcelExportUtil.exportExcel(new ExportParams(title.toString(),"sheet1"),Employee.class,results);
        OutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        outputStream.close();
        workbook.close();
    }

    @PostMapping("/excelInput")
    public Boolean uploas(@RequestParam("file")MultipartFile multipartFile) throws Exception{
        ImportParams params=new ImportParams();
        params.setHeadRows(2);
        List<EmpExcel> list= ExcelImportUtil.importExcel(multipartFile.getInputStream(),EmpExcel.class,params);
        System.out.println(JSONUtils.toJSONString(list));
        return true;
    }




    @RequestMapping("/in")
    @ResponseBody
    public List<PatientInfo> info(){
        String msg="hahah";
        HeSuanSoapUtil heSuanSoapUtil=new HeSuanSoapUtil();
        String strXml= heSuanSoapUtil.getHeSuan("8","00433876");
        System.out.println(strXml);

        JsonXmlUtils jsonXmlUtils=new JsonXmlUtils();
        JSONObject a= jsonXmlUtils.xml2Json(strXml);
        System.out.println(a+"+++++++++");
        System.out.println("+++++++++++++++++++++++++++++");
        JSONObject body=(JSONObject)a.get("Body");
        System.out.println(body);
        JSONObject RequestSubmitResponse=(JSONObject) body.get("RequestSubmitResponse") ;
        System.out.println(RequestSubmitResponse);
        String RequestSubmitResult= RequestSubmitResponse.getString("RequestSubmitResult");
        System.out.println(RequestSubmitResult);

        JSONObject RequestSubmitResults= jsonXmlUtils.xml2Json(RequestSubmitResult);
        System.out.println(RequestSubmitResults);
        String ResultDesc =RequestSubmitResults.getString("ResultDesc");
        String ResultCode =RequestSubmitResults.getString("ResultCode");
        System.out.println(ResultDesc+"==============="+ResultCode);
        JSONObject ResultList=(JSONObject)RequestSubmitResults.get("ResultList");
        System.out.println(ResultList);
        JSONObject PatientInfo=(JSONObject)ResultList.get("PatientInfo");
        System.out.println(PatientInfo);

        String result= "["+ResultList.getString("PatientInfo")+"]";
        System.out.println(result);
//        PageData param = new PageData();
        List<com.bootjdbc.demo.pojo.PatientInfo> employeeList = JSONObject.parseArray(result, PatientInfo.class);

        return employeeList;
    }
 
}
