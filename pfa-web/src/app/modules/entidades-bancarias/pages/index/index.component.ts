import { Component, OnInit } from '@angular/core';
import { EntidadBancaria } from 'src/app/core/models/entidad-bancaria';
import { EntidadBancariaService } from 'src/app/core/services/api/entidad-bancaria.service';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { EntidadesBancariasEditComponent } from '../edit/edit.component';
import { ModalResult } from 'src/app/shared/extensions/ModalResult';

@Component({
    selector: 'entidades-bancarias-index-page',
    templateUrl: 'index.component.html'
})
export class EntidadesBancariasIndexPage implements OnInit {
    entidadesBancarias: EntidadBancaria[];

    constructor(private entidadBancariaService: EntidadBancariaService,
        private modalService: NgbModal) {

    }

    async ngOnInit() {
        this.getAll();
    }

    async getAll() {
        this.entidadesBancarias = await this.entidadBancariaService.getAll();
    }

    async edit(entidadBancaria: EntidadBancaria) {
        const modalRef = this.modalService.open(EntidadesBancariasEditComponent);

        if (entidadBancaria) {
            modalRef.componentInstance.codigo = entidadBancaria.codigo;
        }

        var result = await modalRef.result;
        if (result == ModalResult.Ok) {
            this.getAll();
        }
    }

    async delete(entidadBancaria: EntidadBancaria) {
        await this.entidadBancariaService.delete(entidadBancaria.codigo);
        this.getAll();
    }
}