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
import com.thinkgem.jeesite.modules.or.entity.House;
import com.thinkgem.jeesite.modules.or.service.HouseService;

/**
 * houseController
 * @author ThinkGem
 * @version 2015-02-19
 */
@Controller
@RequestMapping(value = "${adminPath}/or/house")
public class HouseController extends BaseController {

	@Autowired
	private HouseService houseService;
	
	@ModelAttribute
	public House get(@RequestParam(required=false) String id) {
		if (StringUtils.isNotBlank(id)){
			return houseService.get(id);
		}else{
			return new House();
		}
	}
	
	@RequiresPermissions("or:house:view")
	@RequestMapping(value = {"list", ""})
	public String list(House house, HttpServletRequest request, HttpServletResponse response, Model model) {
		User user = UserUtils.getUser();
		if (!user.isAdmin()){
			house.setCreateBy(user);
		}
        Page<House> page = houseService.find(new Page<House>(request, response), house); 
        model.addAttribute("page", page);
		return "modules/" + "or/houseList";
	}

	@RequiresPermissions("or:house:view")
	@RequestMapping(value = "form")
	public String form(House house, Model model) {
		model.addAttribute("house", house);
		return "modules/" + "or/houseForm";
	}

	@RequiresPermissions("or:house:edit")
	@RequestMapping(value = "save")
	public String save(House house, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, house)){
			return form(house, model);
		}
		houseService.save(house);
		addMessage(redirectAttributes, "保存house'" + house.getHouseType() +" " +house.getAddress()+" "+ house.getTelephone()+"'成功");
		return "redirect:"+Global.getAdminPath()+"/or/house/?repage";
	}
	
	@RequiresPermissions("or:house:edit")
	@RequestMapping(value = "delete")
	public String delete(String id, RedirectAttributes redirectAttributes) {
		houseService.delete(id);
		addMessage(redirectAttributes, "删除house成功");
		return "redirect:"+Global.getAdminPath()+"/or/house/?repage";
	}

}
