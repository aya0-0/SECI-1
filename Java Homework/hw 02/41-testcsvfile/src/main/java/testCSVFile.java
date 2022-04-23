import java.io.*;

public class testCSVFile {

    public static void main(String[] args) {
        try {
            //得到csv文件中的所有数据 并且在fileText的第一行保存表头
            //rows:数据行数（fileText中的行数=数据行数+1）
            int rows = 0;
            String fileText[][] = new String[100][5];
            File csv = new File(args[0]);
            BufferedReader fr = new BufferedReader(new FileReader(csv));
            String lineData = "";
            fileText[rows] = new String[]{"Last_name", "First_name", "Salary", "Department", "Employee_id"};
            while ((lineData = fr.readLine()) != null){
                fileText[rows+1] = lineData.split(",");
                rows++;
            }

            //获得指令行
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String[] command = br.readLine().split(" ");
            int command_length = command.length;

            //获得select的关键字 及其对应的列index
            String[] select = command[1].split(",");
            int select_length = select.length;
            int[] select_cols = new int[select_length];

            //如果不进行select，则select_cols = {-1}
            if (select[0].equals("*")){
                select_cols[0] = -1;
            }
            else {
                int i = 0;
                for (String select_item: select){
                    if (select_item.equals("Last_name")){
                        select_cols[i] = 0;
                        i++;
                    }
                    if (select_item.equals("First_name")){
                        select_cols[i] = 1;
                        i++;
                    }
                    if (select_item.equals("Salary")){
                        select_cols[i] = 2;
                        i++;
                    }
                    if (select_item.equals("Department")){
                        select_cols[i] = 3;
                        i++;
                    }
                    if (select_item.equals("Employee_id")){
                        select_cols[i] = 4;
                        i++;
                    }
                }
            }


            //获得order的排序关键字 及其对应的列index
            String order = null;
            int order_col = -1;
            if (command_length == 5 || command_length == 7){
                order = command[4];

                if (order.equals("Salary")){
                    order_col = 2;
                }
                if (order.equals("Employee_id")){
                    order_col = 4;
                }
            }


            //获得limit
            int limit = rows;
            if (command_length == 7){
                limit = Integer.parseInt(command[6]);
            }
            if (command_length == 4){
                limit = Integer.parseInt(command[3]);
            }

            //对所有数据根据order进行冒泡排序
            if (order_col != -1){
                for (int i=1;i<rows;i++){
                    int a = Integer.parseInt(fileText[i][order_col]);
                    int b = Integer.parseInt(fileText[i+1][order_col]);

                    if (a<b){
                        String[] temp = fileText[i];
                        fileText[i] = fileText[i+1];
                        fileText[i+1] = temp;
                    }
                }
            }

            //打印fileText中与select对应的列
            for (int i=0;i<limit+1;i++){
                if (select_cols[0] == -1){
                    for (int j=0;j<5;j++){
                        System.out.print(fileText[i][j]);
                        if (j != 4){
                            System.out.print("    ");
                        }
                    }
                    System.out.println();
                }
                else {
                    for (int j:select_cols){
                        System.out.print(fileText[i][j]);
                        if (j != select_cols[select_length-1]){
                            System.out.print("    ");
                        }
                    }
                    System.out.println();
                }
            }
        }catch (IOException e){

        }

    }

}
