package com.test.springboot.controller;
import com.test.springboot.entity.*;
import com.test.springboot.service.*;
import com.test.springboot.utils.result.DataResult;
import com.test.springboot.vo.CompanyVo;
import com.test.springboot.vo.InstitutionVo;
import com.test.springboot.vo.JobHuntingVo;
import com.test.springboot.vo.RecuitmentVo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.print.attribute.standard.DateTimeAtCompleted;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("info")
public class InfoController {
    @Resource
    private CompanyService companyService;
    @Resource
    private InstitutionService institutionService;
    @Resource
    private JobHuntingService jobHuntingService;
    @Resource
    private RecruitmentService recruitmentService;
    @Resource
    private  ResumeJutiService resumeJutiService;
    @Resource
    private  ResumeService resumeService;
    @RequestMapping("getCompList")
    public DataResult institution(Integer page,Integer limit){
        CompanyVo companyVo=new CompanyVo();
        System.out.println("page:" +page);
        System.out.println("limit: "+limit);
        companyVo.setPage((page-1)*limit);
        companyVo.setLimit(limit);
        List<Company> counts=companyService.getcount(companyVo);

        long count =counts.size();
//冒泡排序
        List<CompanyVo> companyList=companyService.getallcomany1(companyVo);

        for (int i = 0; i < companyList.size() - 1; i++) {
            for (int j = 0; j < companyList.size() - i - 1; j++) {
                if (companyList.get(j).getHot() < companyList.get(j + 1).getHot()) {
                    CompanyVo temp = companyList.get(j);
                    companyList.set(j, companyList.get(j + 1));
                    companyList.set(j + 1, temp);
                }
            }
        }



        return DataResult.successByTotalData(companyList,count);


    }
    @RequestMapping("getInstList")
    public DataResult institution1(){
        InstitutionVo institutionVo=new InstitutionVo();

        List<InstitutionVo> jobbhunt=institutionService.getallinstitution(institutionVo);
        List<Institution> counts=institutionService.getcount(institutionVo);
        long count =counts.size();
        quickSort(jobbhunt, 0, jobbhunt.size() - 1);
        for (int i = 0; i < count; i++) {
            System.out.println(jobbhunt.get(i).getHot());
        }
        return DataResult.successByTotalData(jobbhunt,count);
    }
    @RequestMapping("getResuList")
    public DataResult jobhunt(){
        JobHuntingVo jobHuntingVo=new JobHuntingVo();
        List<JobHuntingVo> jobbhunt=jobHuntingService.getalljob(jobHuntingVo);

//        List<JobHunting> counts=jobHuntingService.getcount(jobHuntingVo);
//        System.out.println();
        long count =jobbhunt.size();


        return DataResult.successByTotalData(jobbhunt,count);

    }
    @RequestMapping("searchResuByDesc")
    public DataResult search4(String desc){

        List<JobHuntingVo> jobbhunt=jobHuntingService.getjob(desc);
//        List<JobHunting> counts=jobHuntingService.getcount1(desc);
        long count =jobbhunt.size();
        return DataResult.successByTotalData(jobbhunt,count);

    }
    @RequestMapping("searchInstByName")
    public DataResult  search(String name){
        InstitutionVo institutionVo =new InstitutionVo();
        institutionVo.setName(name);
        List<Institution> counts=institutionService.getcount1(name);
        long count =counts.size();

        List<InstitutionVo> jobbhunt=institutionService.getinstitution(name);
//        for (int i = 0; i < count; i++) {
//
//        }
//          int pivot=jobbhunt.get(0).getHot();
//          int  i=0;
//         int  j=count1;
//          while(i<j){
//              while(i<j&&jobbhunt.get(j).getHot()>pivot){
//                  j--;
//              }
//              while ((i<j)&&(jobbhunt.get(i).getHot()<pivot)){
//                  i++;
//              }
//              if(jobbhunt.get(i).getHot()==jobbhunt.get(j).getHot()&&(i<j)){
//                  i++;
//              }else {
//                  int temp=jobbhunt.get(i).getHot();
//                  jobbhunt.get(i).getHot()=jobbhunt.get(j).getHot();
//              }
//          }
        quickSort(jobbhunt, 0, jobbhunt.size() - 1);
        for (int i = 0; i < count; i++) {
            System.out.println(jobbhunt.get(i).getHot());
        }
        return DataResult.successByTotalData(jobbhunt,count);
    }
    @RequestMapping("searchCompByName")
    public DataResult  search1( String name,Integer page,Integer limit){
        CompanyVo companyVo=new CompanyVo();
        System.out.println(name);
        System.out.println(page);
        System.out.println(limit);
        companyVo.setLimit(limit);
        companyVo.setPage((page-1)*limit);
        companyVo.setName(name);

        List<CompanyVo> jobbhunt=companyService.getallcomany2(companyVo);
        for (int i = 0; i < jobbhunt.size() - 1; i++) {
            for (int j = 0; j < jobbhunt.size() - i - 1; j++) {
                if (jobbhunt.get(j).getHot() < jobbhunt.get(j + 1).getHot()) {
                    CompanyVo temp = jobbhunt.get(j);
                    jobbhunt.set(j, jobbhunt.get(j + 1));
                    jobbhunt.set(j + 1, temp);
                }
            }
        }
        List<Company> counts=companyService.getcount1(companyVo.getName());
        long count =counts.size();
        return DataResult.successByTotalData(jobbhunt,count);
    }
    @RequestMapping("getRecrList")
    public DataResult getallruit(){
        RecuitmentVo recruitmentVo=new RecuitmentVo();
        List<RecuitmentVo> recruit=recruitmentService.getrecruit(recruitmentVo);
//        List<Recruitment> counts=recruitmentService.getrecount(recruitmentVo);
        long count =recruit.size();
        for(RecuitmentVo x : recruit){
            //x.setDescription("/////");
        }
//       插入排序
        recruit=sortRecruit(recruit);
//        for (int i = 0; i < count; i++) {
//            System.out.println(recruit.get(i).getHot());
//        }
        return DataResult.successByTotalData(recruit,count);
    }
    @RequestMapping("searchRecrByDesc")
    public DataResult search2(String desc){
        System.out.println(desc);
        List<RecuitmentVo> recruit=recruitmentService.getrecruit1(desc);
//        List<Recruitment> counts=recruitmentService.getcount1(desc);
        long count =recruit.size();
        recruit=sortRecruit(recruit);
        return DataResult.successByTotalData(recruit,count);
    }
    @RequestMapping("insthot")
    public  DataResult addhot(Integer id){

        if(institutionService.searchhot(id)==false){
            institutionService.sethot(id);

        }

        return  new DataResult(true,"成功",institutionService.updatehot(id));
    }
    @RequestMapping("recuthotadd")
    public  DataResult addrechot(Integer id){

        if(!recruitmentService.searchhot(id)){
            recruitmentService.setHot(id);
        }


        return new DataResult(true,"增加成功",recruitmentService.addhot(id));

    }
    @RequestMapping("recuthotreduce")
    public  DataResult reducerechot(Integer id){
        Recruitment recruitment =recruitmentService.queryById(id);
        if(!recruitmentService.searchhot(id)){
            recruitmentService.setHot(id);
        }

        return new DataResult(true,"增加成功",recruitmentService.reducehot(id));

}
    private void quickSort(List<InstitutionVo> list, int low, int high) {
        if (list == null || list.size() <= 1 || low >= high) {
            return;
        }

        int i = low;
        int j = high;
        // 取中间的值作为pivot
        InstitutionVo pivot = list.get((low + high) / 2);

        while (i <= j) {
            while (list.get(i).getHot()>pivot.getHot()) {
                i++;
            }
            while (list.get(j).getHot()<pivot.getHot()) {
                j--;
            }
            if (i <= j) {
                InstitutionVo temp = list.get(i);
                list.set(i, list.get(j));
                list.set(j, temp);
                i++;
                j--;
            }
        }

        if (low < j) {
            quickSort(list, low, j);
        }
        if (i < high) {
            quickSort(list, i, high);
        }
    }
    private void quickSort1(List<RecuitmentVo> list, int low, int high) {
        if (list == null || list.size() <= 1 || low >= high) {
            return;
        }

        int i = low;
        int j = high;
        // 取中间的值作为pivot
        RecuitmentVo pivot = list.get((low + high) / 2);

        while (i <= j) {
            while (list.get(i).getHot()>pivot.getHot()) {
                i++;
            }
            while (list.get(j).getHot()<pivot.getHot()) {
                j--;
            }
            if (i <= j) {
                RecuitmentVo temp = list.get(i);
                list.set(i, list.get(j));
                list.set(j, temp);
                i++;
                j--;
            }
        }

        if (low < j) {
            quickSort1(list, low, j);
        }
        if (i < high) {
            quickSort1(list, i, high);
        }
    }
    @RequestMapping("selectFitJob")
    public DataResult selectFitJob(@RequestBody User user){
        //根据个人的求职需求推荐合适的工作给该人员
        /**
         * 第一步 得到用户简历
         * 第二步 查询所有的招聘信息
         * 第三步 调换顺序,给用户最想要的招聘信息
         * */
        Resume user_resume= resumeService.select1(user.getId());
        ResumeJuti resumeJuti=resumeJutiService.queryById(user_resume.getId());

        String my_resume_for = resumeJuti.getResumeFor();
        String my_description = resumeJuti.getDescription();

        RecuitmentVo recruitmentVo=new RecuitmentVo();
        List<RecuitmentVo> recruitmentList=recruitmentService.getrecruit(recruitmentVo);


//        /**
//         * 根据current_description与my_resume_for或my_description的相似度进行比较。
//         * 这里我们可以使用Levenshtein距离（编辑距离）来衡量字符串之间的相似度。
//         * 首先，需要实现一个计算Levenshtein距离的方法：
//         * 之后我们根据此算法来衡量哪个工作最适合当前人员
//         * */
//
//        /**
//         * sortRecruitmentList方法接受一个recruitmentList以及两个描述字符串作为参数，
//         * 根据描述字符串与recruitmentVo的description的相似程度进行排序，
//         * 并返回一个新的排序后的recruitmentList。其中，getLevenshteinDistance方法用于计算两个字符串的相似度
//         * ，我们使用上面的Levenshtein距离（编辑距离）来衡量字符串之间的相似度。
//         * */
//
//        /**
//         * 实现此推荐算法的逻辑是
//         *                  第一:我们是根据用户的求职方向来推断合适的简历信息,如果两份简历信息都满足用户要求,则进行第二步
//         *                  第二:我们根据用户的简历描述来推断哪一份工作最适合他
//         * */

        List<RecuitmentVo> res =sortRecruitmentList(recruitmentList,my_resume_for,my_description);

        return DataResult.successByTotalData(res,(long)res.size());

    }

    public List<RecuitmentVo> sortRecruitmentList(List<RecuitmentVo> recruitmentList, String my_resume_for, String my_description) {
        List<RecuitmentVo> sortedList = new ArrayList<>(recruitmentList);

        Collections.sort(sortedList, new Comparator<RecuitmentVo>() {
            @Override
            public int compare(RecuitmentVo o1, RecuitmentVo o2) {
                double similarity1 = getLevenshteinDistance(o1.getDescription(), my_resume_for);
                double similarity2 = getLevenshteinDistance(o2.getDescription(), my_resume_for);

                if (similarity1 == similarity2) {
                    similarity1 = getLevenshteinDistance(o1.getDescription(), my_description);
                    similarity2 = getLevenshteinDistance(o2.getDescription(), my_description);
                }

                return Double.compare(similarity2, similarity1);
            }
        });
        return sortedList;
    }

//    /**
//     * 算法解释和流程解释
//     * 这是一个经典的算法，称为Levenshtein距离（也称为编辑距离）算法，用于计算两个字符串之间的编辑距离，
//     * 即将一个字符串转换成另一个字符串所需的最小编辑操作数。编辑操作包括插入一个字符、删除一个字符、替换一个字符。
//     *
//     * 这个算法使用了动态规划的思想，通过构建一个二维数组dp来记录从一个字符串到另一个字符串的编辑距离。
//     * 数组dp[i][j]表示将字符串a的前i个字符转换为字符串b的前j个字符所需的最小编辑操作数。
//     * 算法执行流程如下：
//     * 初始化第一行和第一列，分别表示将空字符串转换为目标字符串的编辑距离，即插入字符的数量。
//     * 遍历a字符串的每个字符和b字符串的每个字符，根据当前字符是否相等来决定编辑距离：
//     * 如果当前字符相等，则说明不需要进行编辑操作，编辑距离与之前的状态相同。
//     * 如果当前字符不相等，则可以考虑插入、删除或替换操作，选择其中编辑距离最小的操作数并加1。
//     * 最终返回dp[a.length()][b.length()]，即将整个字符串a转换为整个字符串b所需的最小编辑操作数。
//     * 这个算法的时间复杂度为O(m*n)，其中m和n分别为两个字符串的长度。
//     *
//     *
//     *
//     * */

    public static int getLevenshteinDistance(String a, String b) {
        int[][] dp = new int[a.length() + 1][b.length() + 1];

        for (int i = 0; i <= a.length(); i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= b.length(); j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= a.length(); i++) {
            for (int j = 1; j <= b.length(); j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                }
            }
        }

        return dp[a.length()][b.length()];
    }
    public List<RecuitmentVo> sortRecruit(List<RecuitmentVo> recruit) {
        for (int i = 1; i < recruit.size(); i++)
        { RecuitmentVo currentRecruit = recruit.get(i);
            int j = i - 1;
            while (j >= 0 && recruit.get(j).getHot() < currentRecruit.getHot())
            { recruit.set(j + 1, recruit.get(j)); j--; }
            recruit.set(j + 1, currentRecruit); }
        return recruit; }

}
