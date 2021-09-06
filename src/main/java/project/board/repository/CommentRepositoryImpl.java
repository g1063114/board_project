package project.board.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import project.board.entity.Comment;
import project.board.entity.QComment;

import javax.persistence.EntityManager;
import java.util.List;

import static project.board.entity.QComment.comment;

public class CommentRepositoryImpl implements CommentRepositoryCustom{

    @Autowired
    EntityManager em;

    @Override
    public List<Comment> findAllCommentCustom(Long boardId) {
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);

        List<Comment> result = queryFactory
                .selectFrom(comment)
                .leftJoin(comment.parent)
                .fetchJoin()
                .where(comment.board.id.eq(boardId))
                .orderBy(comment.parent.id.asc().nullsFirst(), comment.createdDate.asc())
                .fetch();

        return result;
    }
}
