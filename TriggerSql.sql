

--TRIGGERS SQL SERVER

--MODIFICAR ESTADO DE HORARIO
CREATE TRIGGER [dbo].[ModificaEstadoHorario] ON [dbo].[Cita]
FOR INSERT
AS
UPDATE HA SET HorarioAtencionEstado='NO DISPONIBLE'
FROM HorarioAtencion HA INNER JOIN inserted CITA
ON HA.HorarioAtencionID=CITA.HorarioAtencionID
GO

ALTER TABLE [dbo].[Cita] ENABLE TRIGGER [ModificaEstadoHorario]
GO



--MODIFICAR ESTADO DE CITA

CREATE TRIGGER [dbo].[ModificarEstadoCita] ON [dbo].[Pagos]
FOR INSERT
AS

UPDATE C SET CitaEstado='Asistió'
FROM Cita C INNER JOIN inserted PAGOS
ON C.CitaID=PAGOS.CitaID
WHERE C.CitaID=PAGOS.CitaID
GO

ALTER TABLE [dbo].[Pagos] ENABLE TRIGGER [ModificarEstadoCita]
GO

