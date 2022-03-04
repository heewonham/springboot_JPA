package mvc.springmvc.basic.response;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

public class ResponseViewController {

    @RequestMapping("/response-view-v1")
    public ModelAndView responseViewV1(){
        ModelAndView mv = new ModelAndView("response/hello")
                .addObject("data","hello!");
        return mv;
    }

    // @ResponseBody or RestController -> 문자 그대로
    // @Controller -> view (html) 파일로
    @RequestMapping("/response-view-v2")
    public String responseViewV2(Model model){
        model.addAttribute("data","hello!");
        return "response/hello";
    }

    // 경로이름(url)과 view 렌더링 위치(논리적이름)가 같으면 없어도 됨
    // 추천하지는 않음
    @RequestMapping("/response/hello")
    public void responseViewV3(Model model){
        model.addAttribute("data","hello!");
    }
}
