import mongoose from "mongoose";
const { Schema } = mongoose;
const UsuarioSchema = new Schema(
	{
		nome: {
			type: String,
			required: true,
			trim: true,
		},
		dataNascimento: {
			type: Date,
			required: true,
		},
		sexo: {
			type: String,
			required: true,
			trim: true,
			enum: ["M", "F"],
		},
		email: {
			type: String,
			required: true,
			trim: true,
			unique: true,
			index: true,
		},
		cep:{
			type: String,
			required: true,
			trim: true
		},
		senha: {
			type: String,
			required: true,
		}
	},
	{ timestamps: true }
);
export default mongoose.model("Usuario", UsuarioSchema);