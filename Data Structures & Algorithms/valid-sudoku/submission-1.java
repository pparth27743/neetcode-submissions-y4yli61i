class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        int rows=9, cols=9;
        for(int i=0; i<rows; i++) {
            Set<Character> set = new HashSet<>();
            for(int j=0; j<cols; j++) {
                if(board[i][j] != '.') {
                    if(set.contains(board[i][j])) {
                        return false;
                    }
                    set.add(board[i][j]);
                }
            }
        }

        for(int i=0; i<rows; i++) {
            Set<Character> set = new HashSet<>();
            for(int j=0; j<cols; j++) {
                if(board[j][i] != '.') {
                    if(set.contains(board[j][i])) {
                        return false;
                    }
                    set.add(board[j][i]);
                }
            }
        }

        for(int l=0; l<3; l++){
            for(int k=0; k<3; k++) {
                Set<Character> set = new HashSet<>();
                for(int i=0; i<3; i++) {
                    for(int j=0; j<3; j++) {
                        if(board[3*l+i][3*k+j] != '.') {
                            if(set.contains(board[3*l+i][3*k+j])) {
                                return false;
                            }
                            set.add(board[3*l+i][3*k+j]);
                        }
                    }
                }
            }
        }
       


        return true;

    }
}
