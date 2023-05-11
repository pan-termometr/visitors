CREATE TABLE visits (
    id SERIAL PRIMARY KEY,
    visit_date DATE NOT NULL,
    ip VARCHAR(15) NOT NULL
);