package service;

import java.util.List;

import dao.StudentDao;
import model.Student;
import model.StudentPage;

public class StudentService {
	 StudentDao blogDao = new StudentDao();
	 //返回pagebean,所有分页需要的信息都去pagebean里查找
	 public StudentPage findPageRecord(int pageno) {
		     //得到总记录数
	        int totalrecord = blogDao.getTotal();
	        StudentPage blogpage = new StudentPage(pageno, totalrecord);
	        List<Student> list = blogDao.getPageRecord(blogpage.getPagenostart(),blogpage.getPagesize());
	        blogpage.setPagerecord(list);
	  return blogpage;
	 }
	}