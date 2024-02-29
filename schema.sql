CREATE TABLE IF NOT EXISTS tasks {
    id LONG AUTO_INCREMENT PRIMARY KEY,
    description varchar(100) NOT NULL,
    status varchar(50),
    create_date date
}