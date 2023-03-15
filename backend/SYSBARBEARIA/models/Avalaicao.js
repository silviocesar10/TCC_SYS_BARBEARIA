import mongoose from "mongoose";
const { Schema } = mongoose;
const AvaliacaoSchema = new Schema(
	{
        usuario: { type: Schema.Types.ObjectId, ref: "Usuario" },
		servico: { type: Schema.Types.ObjectId, ref: "Servico" },
		nota: {
			type: Number,
			required: true,
			trim: true,
		},
		dataAvaliacao: {
			type: Date,
			required: true,
		}
	},
	{ timestamps: true }
);
export default mongoose.model("Usuario", UsuarioSchema);