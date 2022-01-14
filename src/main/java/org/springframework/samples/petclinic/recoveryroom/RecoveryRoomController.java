package org.springframework.samples.petclinic.recoveryroom;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/recoveryroom")
public class RecoveryRoomController {

	@Autowired
	RecoveryRoomService recoveryRoomService;

	@GetMapping(path = "/create")
	public String initCreationForm(ModelMap modelMap) {
		modelMap.addAttribute("recoveryRoom", new RecoveryRoom());
		modelMap.addAttribute("recoveryRoomType", recoveryRoomService.getAllRecoveryRoomTypes());
		return "recoveryroom/createOrUpdateRecoveryRoomForm.jsp";
	}
	
	@PostMapping(path = "/create")
	public String processCreationForm(@Valid RecoveryRoom room, BindingResult result, ModelMap modelMap) {
		String view = "welcome";
		if(result.hasErrors()) {
			modelMap.addAttribute("recoveryRoom", room);
			modelMap.addAttribute("recoveryRoomType", recoveryRoomService.getAllRecoveryRoomTypes());
			return "recoveryroom/createOrUpdateRecoveryRoomForm.jsp";
		} else {
			recoveryRoomService.save(room);
			modelMap.addAttribute("message", "Room succesfully saved!");
		}
		return "recoveryroom/createOrUpdateRecoveryRoomForm.jsp";
	}
}