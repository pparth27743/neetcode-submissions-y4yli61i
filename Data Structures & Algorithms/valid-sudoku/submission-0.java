class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        int rows=9, cols=9;
        for(int i=0; i<rows; i++) {
            Set<Integer> set = new HashSet<>();
            for(int j=0; j<cols; j++) {
                if(board[i][j] != '.') {
                    Integer value = Integer.valueOf(board[i][j]);
                    if(set.contains(value)) {
                        return false;
                    }
                    set.add(value);
                }
            }
        }

        for(int i=0; i<rows; i++) {
            Set<Integer> set = new HashSet<>();
            for(int j=0; j<cols; j++) {
                if(board[j][i] != '.') {
                    Integer value = Integer.valueOf(board[j][i]);
                    if(set.contains(value)) {
                        return false;
                    }
                    set.add(value);
                }
            }
        }

        for(int l=0; l<3; l++){
            for(int k=0; k<3; k++) {
                Set<Integer> set = new HashSet<>();
                for(int i=0; i<3; i++) {
                    for(int j=0; j<3; j++) {
                        if(board[3*l+i][3*k+j] != '.') {
                            Integer value = Integer.valueOf(board[3*l+i][3*k+j]);
                            if(set.contains(value)) {
                                return false;
                            }
                            set.add(value);
                        }
                    }
                }
            }
        }
       


        return true;

    }
}
