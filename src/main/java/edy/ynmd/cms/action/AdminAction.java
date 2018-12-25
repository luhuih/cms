package edy.ynmd.cms.action;

import edy.ynmd.cms.model.Carousel;
import edy.ynmd.cms.model.News;
import edy.ynmd.cms.service.ManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@CrossOrigin
@RequestMapping("manage")
public class AdminAction {

    @Autowired
    private ManageService manageService;



    @PostMapping("addNews")
    @ResponseBody
    public boolean addNews(@RequestBody News news) throws Exception{
        news.setPbdate(new Timestamp(System.currentTimeMillis()));
        return manageService.addNews(news);

    }


    @PostMapping("deleteNews")
    @ResponseBody
    public boolean deleteNews(@RequestBody News news) throws Exception{
        return manageService.deletenews(news.getNewsid());
    }

    @PostMapping("updateNews")
    @ResponseBody
    public boolean updateNews(@RequestBody News news) throws Exception{
        return manageService.updateNews(news);
    }


    @PostMapping("getSingleNews")
    @ResponseBody
    public News getSingleNews(@RequestBody News news) throws Exception{

        return manageService.getNews(news.getNewsid());
    }



    @GetMapping("getNewsList")
    @ResponseBody
    public List<News> getNewsList() throws Exception{

        return manageService.getNewsList();
    }


    @PostMapping("fileUpload")
    @ResponseBody
    public Map fileUpload(MultipartFile file) throws Exception{
             Map m=new HashMap();
        String filename=file.getOriginalFilename();
        System.out.printf("接收到的文件名是 "+filename);
        //获得文件的猴嘴
        int index=filename.lastIndexOf(".");
        String suffexname=filename.substring(index);
        String tosavefilename=String.valueOf(System.currentTimeMillis())+suffexname;


        //检测上传文件目录是否存在
      String savepath="D:\\springbootupload\\";
        File f=new File(savepath);
        if(!f.exists()){
            f.mkdir();
        }
        //将上传的文件保存到该文件加下
      file.transferTo(new File(savepath+tosavefilename));
           m.put("pic",tosavefilename);


return m;
    }




    @RequestMapping("/ckeditorUpload")
    @ResponseBody

    public String ckeditorUpload(@RequestParam("upload") MultipartFile file, String CKEditorFuncNum) throws Exception {

        if (!file.isEmpty()) {
            String finename=file.getOriginalFilename();
            String suffixname=file.getOriginalFilename().substring(finename.lastIndexOf("."));

            finename=String.valueOf(System.currentTimeMillis())+suffixname;

            String filepath="d:/springbootupload/";

            File tf=new File(filepath);
            if(!tf.exists()){
                tf.mkdir();
            }
            String savefile=filepath+finename;
            try {
                file.transferTo(new File(savefile));

                String url="http://localhost/"+finename;

                return "{\"uploaded\":1,\"fileName\":\""+savefile+"\",\"url\":\"" + url + "\"}";

            } catch (IOException e) {
                e.printStackTrace();
                return "{\"uploaded\":0,\"error\":{\"message\":\"upload file is not success!\"}}";

            } catch (IllegalStateException e) {
                e.printStackTrace();
                return "{\"uploaded\":0,\"error\":{\"message\":\"upload file is not success!\"}}";

            }



        }


        return "{\"uploaded\":0,\"error\":{\"message\":\"upload file is not success!\"}}";
    }




    @PostMapping("addCarousel")
    @ResponseBody
    public boolean addCarousel(@RequestBody Carousel carousel) throws Exception{
        return manageService.addCarousel(carousel);
    }


    @GetMapping("getCarouselList")
    @ResponseBody
    public  List<Carousel> getCarouselList() throws Exception{


        return manageService.getCarouselList();
    }





}
