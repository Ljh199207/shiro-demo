package ${basePackage}.${controllerPackage};
import com.ljh.demo.common.controller.BaseController;
import com.ljh.demo.common.entity.FebsResponse;
import com.ljh.demo.common.entity.QueryRequest;
import com.ljh.demo.common.exception.FebsException;
import com.ljh.demo.common.utils.FebsUtil;
import com.ljh.demo.common.utils.FileUtil;
import ${basePackage}.${entityPackage}.${className};
import ${basePackage}.${servicePackage}.I${className}Service;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RegExUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;


/**
* ${tableComment} Controller
*
* @author ${author}
* @date ${date}
*/
@Slf4j
@Validated
@Controller
public class ${className}Controller extends BaseController {

@Autowired
private I${className}Service ${className?uncap_first}Service;

@GetMapping(FebsConstant.VIEW_PREFIX + "${className?uncap_first}")
public String ${className?uncap_first}Index(){
return FebsUtil.view("${className?uncap_first}/${className?uncap_first}");
}

@GetMapping("${className?uncap_first}")
@ResponseBody
public FebsResponse getAll${className}s(${className} ${className?uncap_first}) {
return new FebsResponse().success().data(${className?uncap_first}Service.find${className}s(${className?uncap_first}));
}

@GetMapping("${className?uncap_first}/list")
@ResponseBody
public FebsResponse ${className?uncap_first}List(QueryRequest request, ${className} ${className?uncap_first}) {
Map
<String, Object> dataTable = getDataTable(this.${className?uncap_first}Service.find${className}s(request, ${className?uncap_first}));
return new FebsResponse().success().data(dataTable);
}

@PostMapping("${className?uncap_first}")
@ResponseBody
public FebsResponse add${className}(@Valid ${className} ${className?uncap_first}) {
this.${className?uncap_first}Service.create${className}(${className?uncap_first});
return new FebsResponse().success();
}

@GetMapping("${className?uncap_first}/delete")
@ResponseBody
public FebsResponse delete${className}(${className} ${className?uncap_first}) {
this.${className?uncap_first}Service.delete${className}(${className?uncap_first});
return new FebsResponse().success();
}

@PostMapping("${className?uncap_first}/update")
@ResponseBody
public FebsResponse update${className}(${className} ${className?uncap_first}) {
this.${className?uncap_first}Service.update${className}(${className?uncap_first});
return new FebsResponse().success();
}

}
