import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Solution3 {
    public static int[] solution(String[] Members, String[][] Logs) {
        int[] answer = new int[Members.length];
        boolean[] alarmStatus = new boolean[Members.length];

        // 초기값 알람은 모두 켜짐 상태
        for(int i=0; i<alarmStatus.length; i++) {
            alarmStatus[i] = true;
        }

        // 멤버 이름, 인덱스 매핑
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<Members.length; i++) {
            map.put(Members[i], i);
        }
        // 게시글 작성자 저장 리스트
        ArrayList<String> articleAuthors = new ArrayList<>();

        // 로그 처리
        for(String[] log : Logs) {
            String member = log[0];
            String action = log[1];
            int memberIdx = map.get(member);

            if(action.equals("ARTICLE")) {
                // 게시글 등록
                articleAuthors.add(member); // 해당 게시글 작성자 저장
                // 게시글 작성한 멤버 제외 모두에게 알람 전송
                for(int i=0; i<Members.length; i++) {
                    if(i != memberIdx && alarmStatus[i]) {
                        answer[i]++;
                    }
                }
            }
            else if(action.equals("ALARM")) {
                // 알람 상태 변경
                alarmStatus[memberIdx] = !alarmStatus[memberIdx];
            }
            else if(action.equals("COMMENT")) {
                // 댓글 처리
                int articleIdx = Integer.parseInt(log[2]);
                String articleAuthor = articleAuthors.get(articleIdx);

                // 댓글 단 멤버는 본인 게시글에 댓글 달수 없음
                if(!member.equals(articleAuthor)) {
                    // 게시글 작성자에게 알람 보냄
                    if(alarmStatus[map.get(articleAuthor)]) {
                        answer[map.get(articleAuthor)]++;
                    }
                    int articleAuthorIdx = map.get(articleAuthor);
                    if(alarmStatus[articleAuthorIdx]) {
                        answer[articleAuthorIdx]++;
                    }
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        String[] Members = {"A", "B", "C"};
        String[][] Logs = {
                {"A", "ARTICLE"},
                {"A", "ALARM"},
                {"B", "ARTICLE"},
                {"C", "ALARM"},
                {"B", "ARTICLE"},
                {"B", "COMMENT", "0"},
                {"C", "COMMENT", "1"}
        };

        int[] answer = solution(Members, Logs);
        System.out.println(Arrays.toString(answer));
    }
}
