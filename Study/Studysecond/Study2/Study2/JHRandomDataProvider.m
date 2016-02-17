//
//  JHRandomDataProvider.m
//  Study2
//
//  Created by 박종훈 on 2016. 1. 30..
//  Copyright © 2016년 박종훈. All rights reserved.
//

#import "JHRandomDataProvider.h"
#import "JHStudent.h"
#import "JHStudent+PrivateWrite.h"

@implementation JHRandomDataProvider


- (instancetype)initWithCnt:(NSInteger) cnt
{
    self = [super init];
    if(self)
    {
        _cnt = cnt;
    }
    
    return self;
    
}

#pragma mark - JHDataProvider
- (NSArray *)students
{
    NSMutableArray<JHStudent *> *list = [[NSMutableArray alloc] init];
    NSMutableString *text = [[NSMutableString alloc] init];
    
    
    for (int i=0; i<_cnt; i++)
    {
        JHStudent *objectStudent = [[[JHStudent alloc] init] autorelease];
        
        BOOL isConstrain = false;
        
        NSString *searchString = [self randomStudentNo];
        NSInteger randomJumsu = [self randomStudentJumsu];
        if([text rangeOfString:searchString].location == NSNotFound)
        {
            isConstrain = false;
            
            [objectStudent setStudentNo:searchString];

        }
        else
        {
            //학번 중복
            for( int i=0; i<10; i++)
            {
                NSString *reSearchString = [self randomStudentNo];
                if([text rangeOfString:reSearchString].location == NSNotFound)
                {
                    isConstrain = false;
                    
                    [objectStudent setStudentNo:reSearchString];
                    

                    break;
                }
                else
                {
                    isConstrain = true;
                }
            }
        }
        
        
        [objectStudent setStudentJumsu:randomJumsu];
        
        if(!isConstrain)
        {
            [text appendFormat:@"%@ %zd\n",objectStudent.studentNo, [objectStudent studentJumsu]];
            [list addObject:objectStudent];
        }
    }
    
    [text release];
    
    
    return [list autorelease];
}

- (NSString *)randomStudentNo
{
    NSString *result = @"";
    
    NSInteger randomNo = arc4random_uniform(100000);
    
    NSString *randomData = @"";
    randomData = [NSString stringWithFormat:@"%05zd", randomNo];
    
    result = [@"NT" stringByAppendingString: randomData];
    
    NSLog(@"%@" ,[@"result : " stringByAppendingString: result]);
    
    

    [randomData release];
    return [result autorelease];
}

- (NSInteger)randomStudentJumsu
{
    NSInteger result = 0;
    
    result = arc4random_uniform(100);
    
    
    return result;
}

@end



//    public List<Student> getStudents()
//    {
//        List<Student> list = new ArrayList<>();
//        String text = "";
//
//
//        for(int i=0; i<cnt; i++)
//        {
//
//            Student dtoStudent = new Student();
//
//            dtoStudent.setStudentNo(getRandStudentNo());
//            dtoStudent.setStudentJumsu(getRandStudentJumSu());
//
//            boolean isConstrain = false;
//
//            if(!text.contains(getRandStudentNo()))
//            {
//                isConstrain = false;
//            }
//            else
//            {
//                //학번 중복
//                for(int j=0; j<10; j++)
//                {
//                    System.out.println("중복 데이터  : " +j  +", "+  getRandStudentNo());
//                    if(!text.contains(getRandStudentNo()))
//                    {
//                        isConstrain = false;
//                        break;
//                    }
//                    else
//                    {
//                        isConstrain = true;
//                    }
//                }
//            }
//
//
//            //학번 중복 없을 경우 저장
//            if(!isConstrain)
//            {
//                text += getRandStudentNo() + " " + getRandStudentJumSu() + "\n";
//                list.add(dtoStudent);
//            }
//        }
//
//        return list;
//    }
//
//
//    public String getRandStudentNo()
//    {
//        String result = "";
//
//        int randomNo = new Random().nextInt(100000);
//
//
//        String randomData = "";
//        randomData = String.format("%05d", randomNo);
//
//        result = "NT"+ randomData;
//
//        return result;
//    }
//
//
//    public int getRandStudentJumSu()
//    {
//        int result = new Random().nextInt(100);
//
//        return result;
//    }

