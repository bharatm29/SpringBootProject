package com.space.SpaceAPI.resource;

import com.space.SpaceAPI.models.AstroAPODPicture;
import com.space.SpaceAPI.models.InputDate;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MainViewController {
    @Autowired
    private AstroAPI astroAPI;

    @GetMapping("/homepage")
    public ModelAndView getToHome(HttpSession session){

        return new ModelAndView("home");
    }

    @GetMapping("/apod")
    public ModelAndView getApodView(){
        ModelAndView mv = new ModelAndView("apod");
        mv.addObject("inputDate", new InputDate());
        return mv;
    }

    @PostMapping("/apod")
    public ModelAndView getApodViewPost(HttpSession session, @ModelAttribute("inputDate") InputDate date){
        session.setAttribute("date", date.getDate());
        List<String> testingList = List.of(
                "text1", "text2"
        );
        session.setAttribute("testList", testingList);
        return getApodImage(session);
    }

    @GetMapping("/imgSearch")
    public ModelAndView getImgSearchView(){

        ModelAndView mv = new ModelAndView("imgSearch");
        return mv;
    }

    @GetMapping("/apodImg")
    public ModelAndView getApodImage(HttpSession session){
        ModelAndView apodImage = new ModelAndView("apodImage");
        String date = (String) session.getAttribute("date");
        AstroAPODPicture astroImg = astroAPI.getAPOD(date);

        session.setAttribute("apodImgObj", astroImg);
        return apodImage;
    }
}
