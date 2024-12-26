import java.util.ArrayList;
import java.util.Arrays;

public class Solution3 {
    static class Member {
        private int id;
        private String name;
        private boolean alarm;
        private ArrayList<Integer> commentArticles = new ArrayList<>();

        public Member(int id, String name) {
            this.id = id;
            this.name = name;
            this.alarm = true;
        }

        public int getId() {
            return id;
        }
        public String getName() {
            return name;
        }
        public boolean isAlarm() {
            return alarm;
        }
        public void setId(int id) {
            this.id = id;
        }
        public void setName(String name) {
            this.name = name;
        }
        public void setAlarm(boolean alarm) {
            this.alarm = alarm;
        }
    }

    static class Article {
        private int articleId;
        private String comment;
        private ArrayList<Integer> commentIds = new ArrayList<>();

        public Article(int articleId) {
            this.articleId = articleId;
        }

        public int getArticleId() {
            return articleId;
        }
        public void setArticleId(int articleId) {
            this.articleId = articleId;
        }
    }

    static Member find(Member[] members, String name) {
        for(Member member : members) {
            if(member.getName().equals(name)) {
                return member;
            }
        }
        return null;
    }
    // 게시물 생성되면 본인 제외 다른사람들에게 알람
    static void createArticle(Member[] members, String name, int[] answer) {
        for(Member member : members) {
            if(member.getName().equals(name)) {
                Article article = new Article(member.getId());
            }
            else if(!member.getName().equals(name) && member.isAlarm()) {
                answer[member.getId()]++;
            }
        }
    }

    static void createComment(Member[] members, String name) {

    }


    public static int[] solution(String[] Members, String[][] Logs) {
        int[] answer = new int[Members.length];

        Member[] members = new Member[Members.length];
        for(int i=0; i<Members.length; i++) {
            members[i] = new Member(i, Members[i]);
        }

        for(int i=0; i<Logs.length; i++) {
            String[] inputs = Logs[i];

            String name = inputs[0];
            String command = inputs[1];
            Member member = find(members, name);

            switch(command) {
                case "ALARM":
                    if(member.isAlarm()) {
                        member.setAlarm(false);
                    }
                    else
                        member.setAlarm(true);
                    break;

                case "ARTICLE":
                    createArticle(members, name, answer);
                    break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] Members = {"A", "B", "C"};
        String[][] Logs = {{"A", "ARTICLE"},
                {"A", "ALARM"},
                {"B", "ARTICLE"},
                {"C", "ALARM"},
                {"B", "ARTICLE"}
        };
        int[] answer = solution(Members, Logs);
        System.out.println(Arrays.toString(answer));
    }
}
