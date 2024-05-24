USE `examen-ces3`;

-- Insertions for projects
INSERT INTO projects (project_name, manager, details, createdAt) VALUES
('proyecto3', 'profesor3', 'Este proyecto sirve para bli bli', NOW()),
('proyecto4', 'profe4', 'Este proyecto sirve para blu blu', NOW());

-- Selections for projects
SELECT * FROM projects WHERE id = 1;

SELECT project_name, manager FROM projects WHERE createdAt >= '2024-05-23';

-- Updates for projects
UPDATE projects SET manager = 'nuevoProfesor1', updatedAt = NOW() WHERE id = 1;

UPDATE projects SET details = 'Detalles actualizados para proyecto2', updatedAt = NOW() WHERE id = 2;

-- Insertions for tasks
INSERT INTO tasks (title, status, priority, id_project, createdAt) VALUES
('tarea3', 'No iniciada', 3, 1, NOW()),
('tarea4', 'Completada', 1, 2, NOW());

-- Selections for tasks
SELECT * FROM tasks WHERE id = 1;

SELECT title, status FROM tasks WHERE id_project = 2;

-- Updates for tasks
UPDATE tasks SET status = 'En proceso', updatedAt = NOW() WHERE id = 1;

UPDATE tasks SET priority = 4, updatedAt = NOW() WHERE id = 2;