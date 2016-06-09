package com.mittalmohit.hotelbooking.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.mittalmohit.hotelbooking.dao.RoomDAO;
import com.mittalmohit.hotelbooking.exception.AdException;
import com.mittalmohit.hotelbooking.pojo.UserAccount;

@Controller
@RequestMapping({"/views/affiliateworkflow/addroom"})
public class AffiliateAddRoomController {
	
	
	@Autowired
	ServletContext context;
	@Autowired
	RoomDAO roomDao;
	
	
	@RequestMapping(method = RequestMethod.POST)
	protected String doSubmitAction(@RequestParam("photo") MultipartFile photo,HttpServletRequest request) throws Exception {
		
		String errormsg ="";
		String roomType = request.getParameter("roomtype");
		roomType = roomType.replaceAll("[^\\dA-Za-z]", "").replaceAll("\\s+", "+").trim();
		int rate;
		boolean acInRoom = false, refrigeratorInRoom = false, soundProof = false;
		try{
			
			rate = Integer.parseInt(request.getParameter("rate"));
			if(rate<=0){
				errormsg = "Please enter Valid Price";
				request.setAttribute("errormsg",errormsg);
				System.out.println(errormsg + " User Entered Negative Number or zero");
				return "/affiliateworkflow/addroom";
			}
			
		}catch(NumberFormatException e){
			errormsg = "Please enter Valid Price";
			request.setAttribute("errormsg",errormsg);
			System.out.println(errormsg);
			return "/affiliateworkflow/addroom";
		}
		try{
			String[] services = request.getParameterValues("services");
			
			for (String service: services){
				if(service.equals("acinroom")){
					acInRoom = true;
				}else if(service.equals("refrigeratorinroom")){
					refrigeratorInRoom = true;
				}else if(service.equals("soundproof")){
					soundProof = true;
				}
			}
		}catch(NullPointerException e){
			System.out.println("No Service selected");
		}
		
		
		
		HttpSession session= request.getSession();
		UserAccount userAccount = (UserAccount)session.getAttribute("user");
		
		
		//checking if file is not empty and of type jpeg or png
		if (!photo.isEmpty() && (photo.getContentType().equals("image/jpeg") || photo.getContentType().equals("image/png"))) {
            try {
                byte[] bytes = photo.getBytes();
 
                // Creating the directory to store file
                String rootPath = "hotelbooking" + File.separator + "hotelbooking" 
                		+ File.separator + "src" + File.separator + "main" + File.separator + "webapp" +
                		File.separator + "WEB-INF" + 
                					File.separator +"images" + File.separator + "rooms";
                
                
                String contextPath = context.getRealPath("");
                String[] parts = contextPath.split(".metadata");
                
                String filePath = parts[0].concat(rootPath);
                
               
                File dir = new File(filePath);
                if (!dir.exists())
                    dir.mkdirs();
                
                String filePathWithExtension = dir.getAbsolutePath()
                        + File.separator + userAccount.getUserName() + System.currentTimeMillis() + ".jpg";
                // Create the file on server
                File serverFile = new File(filePathWithExtension);
                BufferedOutputStream stream = new BufferedOutputStream(
                        new FileOutputStream(serverFile));
                stream.write(bytes);
                stream.close();
                System.out.println("File Saved at " + filePathWithExtension);
                
                //Saving room details into database
                
                try {
    				
    				roomDao.create(roomType, filePathWithExtension, acInRoom, refrigeratorInRoom, soundProof,
    	            		rate, userAccount);				
    				System.out.print("DAO successful");
    			
    			} 
    			catch (Exception e) {
    				errormsg = "Failed to Save to databse. Reason: " + e.getMessage();
    				request.setAttribute("errormsg",errormsg);
    				System.out.println(errormsg);
    				return "/affiliateworkflow/addroom";
    			}
            } catch (Exception e) {
                errormsg = "Failed to Upload the photo. Reason: " + e.getMessage();
                request.setAttribute("errormsg",errormsg);
                System.out.println(errormsg);
                return "/affiliateworkflow/addroom";
            }
        } else {
        	errormsg = "You failed to upload file because the file was empty.";
            return "/affiliateworkflow/addroom";
        }
		
		return "/affiliateworkflow/roomadded";
	}
	
	@RequestMapping(method = RequestMethod.GET)
	protected String doGet(HttpServletRequest request, HttpServletResponse response) throws Exception {
		UserAccount userAccount = (UserAccount) request.getSession().getAttribute("user");
		if(userAccount.getUserRole().equals("affiliate")){
			System.out.println("Affiliate Add Room Controller");
			return "/affiliateworkflow/addroom";
		}
		else{
			return "index";
		}
		
	}
	
}
