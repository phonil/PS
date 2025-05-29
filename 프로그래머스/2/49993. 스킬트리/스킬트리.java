class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        /*
        Idea. 
        각 스킬 트리에서 skill에 해당되는 것 외에 다 날리기
        그 후 skill에 포함되는지 확인
            가능한 스킬 트리는 skill의 부분 집합이기 때문
        */
        boolean[] skillCheck = new boolean[26];
        for(int i = 0; i < skill.length(); i++) 
            skillCheck[skill.charAt(i) - 'A'] = true;
        
        for(int i = 0; i < skill_trees.length; i++) {
            String skill_tree = skill_trees[i];
            for(int j = 0; j < skill_tree.length(); j++) {
                char c = skill_tree.charAt(j);
                if(!skillCheck[c - 'A'])
                    skill_tree = skill_tree.replace(Character.toString(c), " ");
            }
            skill_tree = skill_tree.replaceAll(" ", "");
            if(skill.startsWith(skill_tree))
                answer++;
        }
        return answer;
    }
}