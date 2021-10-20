DROP PROCEDURE IF EXISTS Alter_Table;
DELIMITER $$
CREATE PROCEDURE Alter_Table()
BEGIN
    DECLARE _count INT;
    SET _count = (SELECT COUNT(*)
                  FROM INFORMATION_SCHEMA.COLUMNS
                  WHERE table_name = 'user'
                    AND table_schema = DATABASE()
                    AND column_name = 'ttt');
    IF _count = 0 THEN
        ALTER TABLE `user`
            ADD `ttt` INT(1) NOT NULL DEFAULT '0';
    END IF;
END $$
DELIMITER ;
CALL Alter_Table;
DROP PROCEDURE IF EXISTS Alter_Table;






