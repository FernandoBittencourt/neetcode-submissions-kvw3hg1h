class Solution {
    public int characterReplacement(String s, int k) {
        int res = 0;

        for (char target = 'A'; target <= 'Z'; target++) {
            int left = 0;
            int trocas = 0;

            for (int right = 0; right < s.length(); right++) {
                // se for diferente da letra alvo, precisa trocar
                if (s.charAt(right) != target) {
                    trocas++;
                }

                // se passou do limite, encolhe janela
                while (trocas > k) {
                    if (s.charAt(left) != target) {
                        trocas--;
                    }
                    left++;
                }

                // atualiza melhor tamanho
                res = Math.max(res, right - left + 1);
            }
        }

        return res;
    }
}
