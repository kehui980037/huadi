package Servlet;

import Bean.DormBean;
import Bean.StudentBean;
import Dao.DormDao;
import Dao.StudentDao;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import javax.management.StandardEmitterMBean;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "HandleDormServlet")
public class HandleDormServlet extends HttpServlet {
    public static final int DIS_DORM = 0;
    public static final int GET_DORM_LIST = 1;
    public static final int CHANGE_STU_DORM = 2;
    public static final int GET_A_BUILD_DORM = 3;
    public static final int GET_A_DORM = 4;
    public static final int CLASS_STUDENT = 5;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        int type = Integer.parseInt(request.getParameter("type"));
        switch (type){
            case DIS_DORM:
                List<String> classNameList = StudentDao.getClassNameList();
                int studentNumber = StudentDao.getStudentCount();
                int buildNumberNeed = (studentNumber/360)+1;
                List<StudentBean> g_list = new ArrayList<>();
                List<StudentBean> b_list = new ArrayList<>();
                System.out.println(buildNumberNeed);
                for(int className = 0; className<classNameList.size();className++){
                    List<StudentBean> list = StudentDao.getGirlListByClassName(classNameList.get(className));
                    g_list.addAll(list);
                }
                for(int className = 0; className<classNameList.size();className++){
                    List<StudentBean> list = StudentDao.getBoyListByClassName(classNameList.get(className));
                    b_list.addAll(list);
                }
                g_list.addAll(b_list);
                int number = 0;
                try {
                    for (int buildCount = 1;buildCount <= buildNumberNeed;buildCount++){
                        for (int floorCount = 1; floorCount <= 5; floorCount++){
                            for(int dormNumebr = 1; dormNumebr <= 18; dormNumebr++){
                                for(int peopleCount = 1; peopleCount <= 4; peopleCount++){
                                    int dornnn = Integer.parseInt(floorCount+"0"+dormNumebr);
                                    StudentDao.setBuildNumberDormNumber(g_list.get(number).getId(),buildCount,dornnn);
                                    //System.out.println("id is :" + g_list.get(number).getId());
                                    DormDao.addPeopleToDorm(g_list.get(number).getId());
                                    number++;
                                }
                            }
                        }
                    }
                    response.getWriter().write("0");
                }catch (IndexOutOfBoundsException e){
                    //e.printStackTrace();
                }
                break;
            case GET_DORM_LIST:
                List<StudentBean> list = StudentDao.getAllStudent();
                String responseText = JSON.toJSONString(list);
                //System.out.println(responseText);
                response.getWriter().write(responseText);
                break;
            case CHANGE_STU_DORM:
                int stu_id = Integer.parseInt(request.getParameter("stu_id"));
                String stu_name = request.getParameter("stu_name");
                String stu_sex = request.getParameter("stu_sex");
                String stu_class = request.getParameter("stu_class");
                String stu_major = request.getParameter("stu_major");
                String stu_number = request.getParameter("stu_number");
                int stu_build = Integer.parseInt(request.getParameter("stu_build"));
                int stu_dorm = Integer.parseInt(request.getParameter("stu_dorm"));
                System.out.println(stu_id);
                System.out.println(stu_name);
                System.out.println(stu_sex);
                System.out.println(stu_class);
                System.out.println(stu_build);
                System.out.println(stu_dorm);
                if(StudentDao.changeStudentInfo(stu_id,stu_number,stu_name,stu_sex,stu_major,16,stu_class,stu_build,stu_dorm)){
                    response.getWriter().write("0");
                }else {
                    response.getWriter().write("1");
                }
                break;
            case GET_A_BUILD_DORM:
                int buildNumber = Integer.parseInt(request.getParameter("buildNumber"));
                List<DormBean> list1 = DormDao.getDormList(buildNumber);
                String responseText2 = JSON.toJSONString(list1);
                response.getWriter().write(responseText2);
                break;
            case GET_A_DORM:
                int buildNumber2 = Integer.parseInt(request.getParameter("buildNumber"));
                int dormNumber = Integer.parseInt(request.getParameter("dormNumber"));
                List<StudentBean> list2 = StudentDao.getStudentListByDormNumberAndBuildNumber(buildNumber2,dormNumber);
                String resText = JSON.toJSONString(list2);
                response.getWriter().write(resText);
                break;

            case CLASS_STUDENT:
                String classNum = request.getParameter("classNum");
                System.out.println("classNum is :" + classNum);
                List<StudentBean> list3 = StudentDao.getStudentListByClassNum(classNum);
                String res = JSON.toJSONString(list3);
                response.getWriter().write(res);
                break;

        }
    }
}
