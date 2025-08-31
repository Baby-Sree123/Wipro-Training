import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TransactionById } from './transaction-by-id';

describe('TransactionById', () => {
  let component: TransactionById;
  let fixture: ComponentFixture<TransactionById>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TransactionById]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TransactionById);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
