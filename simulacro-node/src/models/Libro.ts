import { DataTypes, Model } from "sequelize";
import sequelize from "../config/database";

class Libro extends Model {
  public id!: number;
  public titulo!: string;
  public autor!: string;
  public isbn!: string;
}

Libro.init(
  {
    id: {
      type: DataTypes.INTEGER,
      autoIncrement: true,
      primaryKey: true,
    },
    titulo: {
      type: DataTypes.STRING,
      allowNull: false,
    },
    autor: {
      type: DataTypes.STRING,
      allowNull: false,
    },
    isbn: {
      type: DataTypes.STRING,
      allowNull: false,
      unique: true,
    },
  },
  {
    sequelize,
    tableName: 'libros',
    timestamps: false
  }
);

export default Libro;