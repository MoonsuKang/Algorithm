class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int videoLength = TimeToSecond(video_len); // 비디오 길이
        int position = TimeToSecond(pos); // 현재 위치
        int openingStart = TimeToSecond(op_start); // 오프닝 시작 시간
        int openingEnd = TimeToSecond(op_end); // 오프닝 끝 시간

        // 시작 위치가 오프닝 구간에 있으면 오프닝 끝으로
        if (position >= openingStart && position <= openingEnd) {
            position = openingEnd;
        }

        for (String command : commands) {
            if (command.equals("prev")) {
                if (position - 10 < 0) {
                    position = 0;
                } else {
                    position -= 10;
                }
            } else if (command.equals("next")) {
                if (position + 10 > videoLength) {
                    position = videoLength;
                } else {
                    position += 10;
                }
            }

            // 명령 실행 후 오프닝 구간에 들어가면 op_end로 이동
            if (position >= openingStart && position <= openingEnd) {
                position = openingEnd;
            }
        }

        return SecondToTime(position);
    }
    
    // mmss를 초로 계산
    private int TimeToSecond(String time){
        String[] panel = time.split(":");
        int minute = Integer.parseInt(panel[0]);
        int second = Integer.parseInt(panel[1]);

        return (minute * 60) + second;
    }

    // 다시 mmss로
    private String SecondToTime(int calculatedSeconds) {
        int minutes = calculatedSeconds / 60;
        int seconds = calculatedSeconds % 60;
        return String.format("%02d:%02d", minutes, seconds);
    }
}


// prev, next, op_skip
// mm:ss 를 초로 변환해서 계산 TimeToSecond