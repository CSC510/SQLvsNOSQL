/**
 * There are <a href="https://github.com/thinkgem/jeesite">JeeSite</a> code generation
 */
package com.thinkgem.jeesite.modules.or.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;
import com.thinkgem.jeesite.modules.or.entity.Application;
import com.thinkgem.jeesite.modules.or.service.ApplicationService;

/**
 * applicationController
 * @author Jentle
 * @version 2015-02-22
 */
@Controller
@RequestMapping(value = "${adminPath}/or/application")
public class ApplicationController extends BaseController {

	@Autowired
	private ApplicationService applicationService;
	
	@ModelAttribute
	public Application get(@RequestParam(required=false) String id) {
		if (StringUtils.isNotBlank(id)){
			return applicationService.get(id);
		}else{
			return new Application();
		}
	}
	
	@RequiresPermissions("or:application:view")
	@RequestMapping(value = {"list", ""})
	public String list(Application application, HttpServletRequest request, HttpServletResponse response, Model model) {
		User user = UserUtils.getUser();
		if (!user.isAdmin()){
			application.setCreateBy(user);
		}
        Page<Application> page = applicationService.find(new Page<Application>(request, response), application); 
        model.addAttribute("page", page);
		return "modules/" + "or/applicationList";
	}

	@RequiresPermissions("or:application:view")
	@RequestMapping(value = "form")
	public String form(Application application, Model model) {
		model.addAttribute("application", application);
		return "modules/" + "or/applicationForm";
	}

	@RequiresPermissions("or:application:edit")
	@RequestMapping(value = "save")
	public String save(Application application, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, application)){
			return form(application, model);
		}
		
		applicationService.save(application);
		addMessage(redirectAttributes, "save application "+application.getId()+"success");
		return "redirect:"+Global.getAdminPath()+"/or/application/?repage";
	}
	
    @RequiresPermissions("or:application:edit")
	@RequestMapping(value = "delete")
	public String delete(String id, RedirectAttributes redirectAttributes) {
		applicationService.delete(id);
		addMessage(redirectAttributes, "删除application成功");
		return "redirect:"+Global.getAdminPath()+"/or/application/?repage";
	}

}
