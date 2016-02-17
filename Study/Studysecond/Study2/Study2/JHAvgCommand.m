//
//  AvgCommand.m
//  Study2
//
//  Created by 박종훈 on 2016. 2. 9..
//  Copyright © 2016년 박종훈. All rights reserved.
//

#import "JHAvgCommand.h"

@implementation JHAvgCommand

#pragma mark - JHCommand.h
-(void)execute:(NSArray *)students
{

    NSInteger sumData = 0;
    for(JHStudent *each in students)
    {
        NSInteger tempData = each.studentJumsu;
        
        sumData += tempData;
    }
    
    NSInteger resultData = sumData / [students count];
    
    
    NSLog(@"AVG data : %zd ", resultData );
    
}

@end


//int sumData = 0;
//
//for (int i = 0; i < students.size(); i++) {
//    int tempData =  students.get(i).getStudentJumsu();
//    sumData += tempData;
//}
//
//String pattern = "####.##";
//DecimalFormat format = new DecimalFormat(pattern);
//
//double resultData = sumData / students.size();
//
//System.out.println("Max value is " + resultData);
