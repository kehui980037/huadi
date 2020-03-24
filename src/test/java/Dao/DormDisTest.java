package Dao;

import Bean.StudentBean;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class DormDisTest {

    @Test
    public void tt(){
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
        g_list.forEach(studentBean -> {
           // System.out.println(studentBean.getSex() + " " + studentBean.getClassNum() + " " + studentBean.getStudentName());
        });
        int number = 0;
        try {
            for (int buildCount = 1;buildCount <= buildNumberNeed;buildCount++){
                for (int floorCount = 1; floorCount <= 5; floorCount++){
                    for(int dormNumebr = 1; dormNumebr <= 18; dormNumebr++){
                        for(int peopleCount = 1; peopleCount <= 4; peopleCount++){
                            int dornnn = Integer.parseInt(floorCount+"0"+dormNumebr);
                            //System.out.println(g_list.get(number).getSex() + " " + g_list.get(number).getClassNum() + " "  + g_list.get(number).getStudentName() +" " + buildCount + " " + dornnn);
                            //number++;
                            //System.out.println(studentBean.getId() + " " + studentBean.getSex() + " " + studentBean.getClassNum() + " " + studentBean.getStudentName()+ " " +buildCount +" " +dornnn);
                            StudentDao.setBuildNumberDormNumber(g_list.get(number).getId(),buildCount,dornnn);
                            number++;
                        }
                    }
                }
            }
        }catch (IndexOutOfBoundsException e){
            //e.printStackTrace();
        }

    }
}
