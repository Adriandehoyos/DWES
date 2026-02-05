import dotenv from 'dotenv';
dotenv.config();
import express from 'express';              
import sequelize from './config/database';
import equiposRoutes from './routes/equiposRoutes';
import antiequiposRoutes from './routes/antiequiposRoutes';
import heroesRoutes from './routes/heroesRoutes';
import villanosRoutes from './routes/villanosRoutes';


const app = express();
app.use(express.json());
app.use(express.urlencoded({ extended: true }));
const PORT = 3000; 

app.get('/', (req, res) => {
  res.send('Servidor funcionando correctamente');
});

sequelize
  .authenticate()
  .then(() => console.log(' Conexión a la base de datos exitosa'))
  .catch((error) => console.error(' Error al conectar la base de datos:', error));

  app.listen(PORT, () => {
  console.log(` Servidor corriendo en http://localhost:${PORT}`);
});

app.use('/api', equiposRoutes);
app.use('/api', antiequiposRoutes);
app.use('/api', heroesRoutes);
app.use('/api', villanosRoutes);