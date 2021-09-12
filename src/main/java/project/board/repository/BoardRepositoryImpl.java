package project.board.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import project.board.entity.Board;
import project.board.entity.QBoard;
import project.board.entity.QMember;

import javax.persistence.EntityManager;

import static project.board.entity.QBoard.board;
import static project.board.entity.QMember.member;

public class BoardRepositoryImpl implements BoardRepositoryCustom{

    private final JPAQueryFactory queryFactory;

    public BoardRepositoryImpl(JPAQueryFactory queryFactory) {
        this.queryFactory = queryFactory;
    }

    @Override
    public Page<Board> boardPaging(Pageable pageable) {
        queryFactory
                .selectFrom(board)
                .leftJoin(board, board.member)
    }
}
