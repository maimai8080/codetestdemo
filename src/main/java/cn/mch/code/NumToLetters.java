package cn.mch.code;

import java.util.*;

/**
 * NumToLetters
 *
 * @Auther: MCH
 * @Date: 2020/12/10/10:47
 */
public class NumToLetters {
    /**
     * Method to initialize data
     */
    public static Map<String, List<String>> initNumMap(){
        Map<String, List<String>>numMap=new HashMap<>();
        numMap.put("0", Arrays.asList(""));
        numMap.put("1",Arrays.asList(""));
        numMap.put("2",Arrays.asList("A","B","C"));
        numMap.put("3",Arrays.asList("D","E","F"));
        numMap.put("4",Arrays.asList("G","H","I"));
        numMap.put("5",Arrays.asList("J","K","L"));
        numMap.put("6",Arrays.asList("M","N","O"));
        numMap.put("7",Arrays.asList("P","Q","R","S"));
        numMap.put("8",Arrays.asList("T","U","V"));
        numMap.put("9",Arrays.asList("W","X","Y","Z"));

        return numMap;
}

    /**
     * Method to numToLetters
     */
    public static void numToLetters(){
        //Prompt for key numbers 1-9
        System.out.println("Please input nums from 0 to 9:");
        String nums="";
        Scanner input = new Scanner(System.in);
        while(true){
            nums=input.next();
            if(!nums.matches("[0-9]{1,2}")){
                System.out.println("Only 0-99 digits can be entered. Please re-enter:");
            }else{
                break;
            }
        }
        StringBuilder arrInput=new StringBuilder("Input:arr[] ={");
        String[] arrStr=nums.split("");
        List<String[]> dataList=new ArrayList<String[]>();

        for(int i=0;i<arrStr.length;i++){
            arrInput.append(arrStr[i]);
            if(i<arrStr.length-1){
                arrInput.append(",");
            }
            //adding data from  Lists to the same Map as the data source
            List<String> lettersList=initNumMap().get(arrStr[i]);
            if(lettersList.size()>0){// Map cannot be forcibly converted to an array  without data
                String[] letterArr= (String[]) lettersList.toArray();
                dataList.add(letterArr);
            }
        }
        arrInput.append("}");
        //Recursively can implement permutations of lists and returns the final permutation Map
        List<String[]> resultList= makeupLetters(dataList,0,null);
        //Print the input
        System.out.println(arrInput.toString());
        System.out.print("Output:");
        //Print and output permutation and combination results
        for(int i=0;i<resultList.size();i++){
            String[] letterArr=resultList.get(i);
            System.out.print(" ");
            for(String s: letterArr){
                System.out.print(s);
            }
        }
    }

    private  static List<String[]> makeupLetters(List<String[]> dataList, int index, List<String[]> resultList){
        if(index==dataList.size()){
            return resultList;
        }

        List<String[]> resultList0=new ArrayList<String[]>();
        if(index==0){//The default of the first column array is to add as many permutations as the number of letters
            String[] dataArr=dataList.get(0);
            for(String s : dataArr){
                resultList0.add(new String[]{s});
            }
        }else{
            String[] dataArr=dataList.get(index);
            for(String[] dataArr0: resultList){
                for(String s : dataArr){
                    //Copy the array and extend the new element
                    String[] dataArrCopy=new String[dataArr0.length+1];
                    System.arraycopy(dataArr0, 0, dataArrCopy, 0, dataArr0.length);
                    dataArrCopy[dataArrCopy.length-1]=s;
                    //Add to the result set
                    resultList0.add(dataArrCopy);
                }
            }
        }
        return makeupLetters(dataList,++index,resultList0);
    }


}
