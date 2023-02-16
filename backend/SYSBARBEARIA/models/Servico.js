import mongoose from "mongoose";
const { Schema } = mongoose;
const ServicoSchema = new Schema(
	{
		nome_prod_serv:{
						type: String,
            required: true,
            trim: true,
		},
		descricacao:{
						type: String,
            required: true,
            trim: true,
			},
		preco:{
						type: Number,
		        required: true,
		},
		tempo_estimado:{
						type: Number,
		        required: true,
			},
		empresa :{ type: Schema.Types.ObjectId, ref: "Empresa"}
	}
);
export default mongoose.model("Servico", ServicoSchema);