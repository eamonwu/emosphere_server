package com.emosphere.emosphere.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import lombok.Data;

/**
 * @TableName comment
 */
@TableName(value = "comment")
@Data
public class Comment implements Serializable {
    /**
     *
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     *
     */
    private Integer postId;

    /**
     *
     */
    private Integer uid;

    /**
     *
     */
    private String content;

    /**
     *
     */
    private Date createTime;

    @TableField(exist = false)
    private List<Reply> replies;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return Objects.equals(id, comment.id) && Objects.equals(postId, comment.postId) && Objects.equals(uid, comment.uid) && Objects.equals(content, comment.content) && Objects.equals(createTime, comment.createTime) && Objects.equals(replies, comment.replies);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, postId, uid, content, createTime, replies);
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", postId=" + postId +
                ", uid=" + uid +
                ", content='" + content + '\'' +
                ", createTime=" + createTime +
                ", additionalField='" + replies + '\'' +
                '}';
    }
}