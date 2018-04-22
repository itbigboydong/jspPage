package model;

import java.util.List;

public class StudentPage {

	private List<Student> pagerecord;//每页记录
	 private int pageno;//当前页
	 private int pagenostart;//每页开始索引
	 private int pagesize=5;//每页多少数据
	 private int totalrecord;//总记录数
	 private int totalpage;//总页数
	  
	 public StudentPage(int pageno,int totalrecord){
	  //pageno totalrecord都可以当做已有信息
	  this.totalrecord=totalrecord;
	  //计算总页数
	  totalpage=(totalrecord%pagesize==0)?totalrecord/pagesize:totalrecord/pagesize+1;
	  //pageno的边界处理
	  if(pageno<=1)
	   this.pageno=1;
	  else if(pageno>=totalpage)
	   this.pageno=totalpage;
	  else
	   this.pageno=pageno;
	  //计算每页开始索引，即每页第一个数据的索引，用于分页查询
	  pagenostart=(this.pageno-1)*pagesize;
	 }
	 public int getPagenostart() {
	  return pagenostart;
	 }
	 public void setPagenostart(int pagenostart) {
	  this.pagenostart = pagenostart;
	 }
	 public List<Student> getPagerecord() {
	  return pagerecord;
	 }
	 public void setPagerecord(List<Student> pagerecord) {
	  this.pagerecord = pagerecord;
	 }
	 public int getPageno() {
	  return pageno;
	 }
	 public void setPageno(int pageno) {
	  this.pageno = pageno;
	 }
	 public int getPagesize() {
	  return pagesize;
	 }
	 public void setPagesize(int pagesize) {
	  this.pagesize = pagesize;
	 }
	 public int getTotalrecord() {
	  return totalrecord;
	 }
	 public void setTotalrecord(int totalrecord) {
	  this.totalrecord = totalrecord;
	 }
	 public int getTotalpage() {
	  return totalpage;
	 }
	 public void setTotalpage(int totalpage) {
	  this.totalpage = totalpage;
	 }
	}