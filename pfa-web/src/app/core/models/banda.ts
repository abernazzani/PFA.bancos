export class Banda {
    codigoBanda: string;
    nroDeMiembros: number;

    static parse(data: any): Banda {
        let banda = new Banda();
        Object.assign(banda, data);
        return banda;
    }
}