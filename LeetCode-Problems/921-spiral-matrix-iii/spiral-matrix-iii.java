class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        ArrayList<ArrayList<Integer>> arr=new ArrayList<>();
        
        int rLim=cStart,bLim=rStart,lLim=cStart,uLim=rStart;
        while(rLim<cols || bLim<rows ||lLim>=0||uLim>=0){
            while(cStart<=rLim+1){
                if(cStart<cols &&cStart>=0 && rStart>=0 && rStart<rows){
            ArrayList<Integer> row=new ArrayList<>();
            row.add(rStart);
            row.add(cStart);
            arr.add(row);
                }
            cStart++;
            }
            rLim++;
            cStart--;
            rStart++;
            while(rStart<=bLim+1){
                if(cStart<cols &&cStart>=0 && rStart>=0 && rStart<rows){
                ArrayList<Integer> row=new ArrayList<>();
                row.add(rStart);
                row.add(cStart);
                arr.add(row);
                }
                rStart++;
            }
            bLim++;
            rStart--;
            cStart--;
            while(cStart>=lLim-1){
                if(cStart<cols &&cStart>=0 && rStart>=0 && rStart<rows){
                ArrayList<Integer> row=new ArrayList<>();
                row.add(rStart);
                row.add(cStart);
                arr.add(row);
                }
                cStart--;
            }
            lLim--;
            rStart--;
            cStart++;
            while(rStart>=uLim-1){
                if(cStart<cols &&cStart>=0 && rStart>=0 && rStart<rows){
                ArrayList<Integer> row=new ArrayList<>();
                row.add(rStart);
                row.add(cStart);
                arr.add(row);
                }
                rStart--;
            }
            uLim--;
            rStart++;
            cStart++;
        }
        
        int[][] arr2D=new int[arr.size()][2];
        for(int i=0;i<arr.size();i++){
            arr2D[i][0]=arr.get(i).get(0);
            arr2D[i][1]=arr.get(i).get(1);
        }
        return arr2D;


        /*
        //GPT ans
        int[][] result = new int[rows * cols][2];
        int index = 0;
        result[index++] = new int[]{rStart, cStart};

        int step = 1; // Initial step size
        int direction = 0; // Direction: 0 -> right, 1 -> down, 2 -> left, 3 -> up
        int r = rStart, c = cStart;

        // Direction arrays for right, down, left, up movements
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};

        while (index < rows * cols) {
            for (int i = 0; i < 2; i++) { // Increase the step size after every two directions
                for (int j = 0; j < step; j++) {
                    r += dr[direction];
                    c += dc[direction];
                    if (r >= 0 && r < rows && c >= 0 && c < cols) {
                        result[index++] = new int[]{r, c};
                    }
                }
                direction = (direction + 1) % 4; // Cycle through directions
            }
            step++;
        }

        return result;*/
    }
}