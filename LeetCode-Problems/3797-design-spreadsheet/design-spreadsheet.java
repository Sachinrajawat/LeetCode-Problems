class Spreadsheet {
    int[][] arr;
    public Spreadsheet(int rows) {
        arr=new int[rows][26];
    }
    
    public void setCell(String cell, int value) {
        int row = Integer.parseInt(cell.substring(1)) - 1;
        int col=cell.charAt(0)-'A';
        arr[row][col]=value;
    }
    
    public void resetCell(String cell) {
        int row = Integer.parseInt(cell.substring(1)) - 1;
        int col=cell.charAt(0)-'A';
        arr[row][col]=0;
    }
    
    public int getValue(String f) {
         int res=0;
        String formula=f.substring(1,f.length());
            String[] arr=formula.split("\\+");
            for(int i=0;i<2;i++){
                if(Character.isLetter(arr[i].charAt(0))){
                int col=arr[i].charAt(0)-'A';
                int row=Integer.parseInt(arr[i].substring(1)) - 1;
                res+=this.arr[row][col];
                }
                else{
                    res+=Integer.parseInt(arr[i]);
                }
            }
    return res;
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */