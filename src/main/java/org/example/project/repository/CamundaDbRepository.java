package org.example.project.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CamundaDbRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CamundaDbRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void removeAllProcessInstances() {
        String sql = "TRUNCATE TABLE ACT_HI_PROCINST";
        jdbcTemplate.execute(sql);
    }

    public void removeAllActiveProcessInstances() {
        String sql = "DELETE FROM ACT_HI_PROCINST WHERE state_ =?";
        jdbcTemplate.update(sql, "state_='ACTIVE'");
    }
}
