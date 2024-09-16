import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        // 장르별 재생 횟수
        HashMap<String, Integer> genrePlayCount = new HashMap<>();
        // 노래 정보
        HashMap<String, List<int[]>> genreSongs = new HashMap<>();
        
        for(int i=0; i < genres.length; i ++) {
            // System.out.println(i);
            String genre = genres[i];
            int play = plays[i];
            // 장르별 총 재생 횟수 갱신
            genrePlayCount.put(genre, genrePlayCount.getOrDefault(genre, 0)+play);
             // 장르별 노래 정보 저장
            genreSongs.putIfAbsent(genre, new ArrayList<>());
            genreSongs.get(genre).add(new int[]{i, play});
            
        }
            // 장르별 총 재생 횟수를 기준으로 장르 정렬
        List<String> sortedGenres = new ArrayList<>(genrePlayCount.keySet());
        sortedGenres.sort((a,b) -> genrePlayCount.get(b) - genrePlayCount.get(a));
        
        List<Integer> bestAlbum = new ArrayList<>();
        
        for(String genre: sortedGenres) {
            // 장르 내 노래를 재생 횟수 내림차순, 고유 번호 오름차순으로 정렬
            List<int[]> songs = genreSongs.get(genre);
            songs.sort((a, b) -> b[1] != a[1] ? b[1] - a[1] : a[0] - b[0]);

             // 장르별 최대 두 곡까지 베스트 앨범에 추가
            for (int i = 0; i < songs.size() && i < 2; i++) {
                bestAlbum.add(songs.get(i)[0]);
            }
        }
        
        return bestAlbum.stream().mapToInt(Integer::intValue).toArray();
    }
}