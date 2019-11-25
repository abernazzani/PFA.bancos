import { Component, OnInit } from '@angular/core';
import { Banda } from 'src/app/core/models/banda';
import { BandasService } from 'src/app/core/services/api/bandas.service';
import { BandasEditComponent } from '../edit/edit.component';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { ModalResult } from 'src/app/shared/extensions/ModalResult';

@Component({
    selector: 'bandas-index',
    templateUrl: 'index.component.html'
})

export class BandasIndexComponent implements OnInit {
    bandas: Banda[];

    constructor(private bandasService: BandasService,
        private modalService: NgbModal) { }

    async ngOnInit() {
        this.getAll();
    }

    async getAll() {
        debugger;
        this.bandas = await this.bandasService.getAll();
    }

    async edit(banda: Banda) {
        const modalRef = this.modalService.open(BandasEditComponent);

        if (banda) {
            modalRef.componentInstance.codigo = banda.codigoBanda;
        }

        var result = await modalRef.result;
        debugger;
        if (result == ModalResult.Ok) {
            this.getAll();
        }
    }

    async delete($event, banda: Banda) {
        debugger;
        await this.bandasService.delete(banda.codigoBanda);
        this.getAll();
        $event.stopPropagation();
    }
}