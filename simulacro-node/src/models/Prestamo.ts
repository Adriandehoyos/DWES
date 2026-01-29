// src/models/prestamo.ts
import { DataTypes, Model } from "sequelize";
import sequelize from "../config/database";
import Libro from "./Libro";
import Usuario from "./Usuario";

class Prestamo extends Model {
  public id!: number;
  public libro_id!: number;
  public usuario_id!: number;
  public fecha_prestamo!: Date;
  public fecha_devolucion!: Date;
}

Prestamo.init(
  {
    id: {
      type: DataTypes.INTEGER,
      autoIncrement: true,
      primaryKey: true,
    },
    libro_id: {
      type: DataTypes.INTEGER,
      allowNull: false,
      references: {
        model: Libro,
        key: 'id'
      }
    },
    usuario_id: {
      type: DataTypes.INTEGER,
      allowNull: false,
      references: {
        model: Usuario,
        key: 'id'
      }
    },
    fecha_prestamo: {
      type: DataTypes.DATEONLY,
      allowNull: false,
    },
    fecha_devolucion: {
      type: DataTypes.DATEONLY,
      allowNull: true,  // Puede ser NULL si aún no se devolvió
    },
  },
  {
    sequelize,
    tableName: 'prestamos',
    timestamps: false
  }
);
// Asociación: Un préstamo pertenece a un libro
Prestamo.belongsTo(Libro, { foreignKey: 'libro_id' });
// Asociación: Un préstamo pertenece a un usuario
Prestamo.belongsTo(Usuario, { foreignKey: 'usuario_id' });

export default Prestamo;