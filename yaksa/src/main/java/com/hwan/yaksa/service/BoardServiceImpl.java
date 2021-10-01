package com.hwan.yaksa.service;

import com.hwan.yaksa.domain.Board;
import com.hwan.yaksa.dto.BoardDTO;
import com.hwan.yaksa.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
    private final int SIZE=10;
    private final BoardRepository boardRepository;

    public void createBoard(BoardDTO boardDTO){
        Board board=new Board();
        board.setTitle(boardDTO.getTitle());
        board.setBoardContent(boardDTO.getBoardContent());
        boardRepository.save(board);
    }

    public List<Board> findAll(Long boardNum){
        return boardRepository.findAll(boardNum);
    }

    public Board find(Long id){
        return boardRepository.find(id);
    }

    public Long getCount(){
        return (boardRepository.getCount()-1)/SIZE+1;
    }

}
