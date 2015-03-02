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
import com.thinkgem.jeesite.modules.cms.service.CategoryService;
import com.thinkgem.jeesite.modules.or.entity.House;
import com.thinkgem.jeesite.modules.or.entity.Room;
import com.thinkgem.jeesite.modules.or.service.HouseService;
import com.thinkgem.jeesite.modules.or.service.RoomService;

/**
 * roomController
 * @author Jentle
 * @version 2015-02-26
 */
@Controller
@RequestMapping(value = "${adminPath}/or/room")
public class RoomController extends BaseController {

	@Autowired
	private RoomService roomService;
	@Autowired
	private HouseService houseService;
	
	@ModelAttribute
	public Room get(@RequestParam(required=false) String id) {
		if (StringUtils.isNotBlank(id)){
			return roomService.get(id);
		}else{
			return new Room();
		}
	}
	
	@RequiresPermissions("or:room:view")
	@RequestMapping(value = {"list", ""})
	public String list(Room room, HttpServletRequest request, HttpServletResponse response, Model model) {
		User user = UserUtils.getUser();
		if (!user.isAdmin()){
			room.setCreateBy(user);
		}
        Page<Room> page = roomService.find(new Page<Room>(request, response), room); 
        model.addAttribute("page", page);
		return "modules/" + "or/roomList";
	}

	@RequiresPermissions("or:room:view")
	@RequestMapping(value = "form")
	public String form(Room room, Model model) {
		if( room.getHouse()!=null && StringUtils.isNotBlank(room.getHouse().getId())){
			
		}else{
		
		}
			
		model.addAttribute("room", room);
		return "modules/" + "or/roomForm";
	}

    @RequiresPermissions("or:room:edit")
	@RequestMapping(value = "save")
	public String save(Room room, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, room)){
			return form(room, model);
		}
		roomService.save(room);		
		addMessage(redirectAttributes, "save room'" + room.getHouse().getId() + "'success");
		String houseId =room.getHouse()!=null? room.getHouse().getId():null;
		return "redirect:"+Global.getAdminPath()+"/or/room/?repage&house.id="+(houseId!=null?houseId:"");
	}
	
	@RequiresPermissions("or:room:edit")
	@RequestMapping(value = "delete")
	public String delete(String id, RedirectAttributes redirectAttributes) {
		roomService.delete(id);
		addMessage(redirectAttributes, "delete room success");
		return "redirect:"+Global.getAdminPath()+"/or/room/?repage";
	}

}
