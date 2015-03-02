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
import com.thinkgem.jeesite.modules.or.entity.House;
import com.thinkgem.jeesite.modules.or.entity.Room;
import com.thinkgem.jeesite.modules.or.service.ApplicationService;
import com.thinkgem.jeesite.modules.or.service.HouseService;
import com.thinkgem.jeesite.modules.or.service.RoomService;

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
	@Autowired
	private HouseService houseService;
	@Autowired
	private RoomService roomService;
	
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
		if(application.getHouse()!=null&& StringUtils.isNotBlank(application.getHouse().getId())){
			House house = houseService.get(application.getHouse().getId());
			application.setHouse(house);	
		}
		
		if(application.getRoom()!=null&& StringUtils.isNotBlank(application.getRoom().getId())){
			Room room = roomService.get(application.getRoom().getId());
			application.setRoom(room);	
		}
		
		model.addAttribute("application", application);
		return "modules/" + "or/applicationForm";
	}

	@RequiresPermissions("or:application:edit")
	@RequestMapping(value = "save")
	public String save(Application application, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, application)){
			return form(application, model);
		}
		
		if(true){
		
			if(application.getHouse().getHouseType()==House.FAMILY_APARTMENT){
				House house = houseService.get(application.getHouse().getId());
				house.changeStatus(1);
				//houseService.save(house);
			}else if(application.getRoom()!=null){
				Room  room = roomService.get(application.getRoom().getId());
				room.changeStatus(1);
				//roomService.save(room);
			}
		}
		applicationService.save(application);
		addMessage(redirectAttributes, "save application "+application.getId()+"success");
		String houseId = application.getHouse()!=null? application.getHouse().getId():null;
		return "redirect:"+Global.getAdminPath()+"/or/application/?repage&house.id="+(houseId!=null?houseId:"");
	}
	
	@RequiresPermissions("or:application:view")
	@RequestMapping(value = "detail")
	public String detail(Application application, Model model){
		model.addAttribute("application", application);
		return "modules/" + "or/applicationDetail";
	}
	
	@RequiresPermissions("or:application:audit")
	@RequestMapping(value = "audit")
	public String audit(Application application, Model model, RedirectAttributes redirectAttributes){
	    applicationService.audit(application);
	    addMessage(redirectAttributes,"Application Approved");
		return "redirect:"+Global.getAdminPath()+"/or/application/detail?repage&id="+application.getId();
	}
	
    @RequiresPermissions("or:application:edit")
	@RequestMapping(value = "delete")
	public String delete(String id, RedirectAttributes redirectAttributes) {
    	Application application = applicationService.get(id);
    	if(application.getId()!=null&&application.getHouse()!=null){
			if(application.getHouse().getHouseType()==House.FAMILY_APARTMENT){
				House house = houseService.get(application.getHouse().getId());
				house.changeStatus(-1);
				//houseService.save(house);
			}else if(application.getRoom()!=null){
				Room  room = roomService.get(application.getRoom().getId());
				room.changeStatus(-1);;
				//roomService.save(room);
			}
		}
		applicationService.delete(id);
		addMessage(redirectAttributes, "delete application");
		String houseId = application.getHouse()!=null? application.getHouse().getId():null;
		return "redirect:"+Global.getAdminPath()+"/or/application/?repage&house.id="+(houseId!=null?houseId:"");
	}

}
